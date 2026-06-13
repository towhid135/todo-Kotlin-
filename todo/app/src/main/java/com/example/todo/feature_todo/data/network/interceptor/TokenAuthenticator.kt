package com.example.todo.feature_todo.data.network.interceptor

import android.content.Context
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.network.interceptor.TokenAuthenticator.Companion.MAX_REFRESH_RETRIES
import com.example.todo.feature_todo.data.remote.TodoApi
import dagger.Lazy
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val api: Lazy<TodoApi>,
    @ApplicationContext private val context: Context
) : Authenticator {

    /**
     * Ensures only one coroutine executes the refresh flow at a time.
     * All other 401-receiving requests wait at [mutex.withLock] and
     * then reuse the freshly persisted token without calling the API again.
     */
    private val mutex = Mutex()

    companion object {
        private const val MAX_REFRESH_RETRIES = 3
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        // Guard: if the refresh endpoint itself returns 401/403, stop immediately
        // to avoid an infinite retry loop.
        if (response.request.url.encodedPath.contains("/auth/refresh")) return null

        return runBlocking {
            mutex.withLock {
                // ── Optimistic check ──────────────────────────────────────────
                // Another request may have already completed a refresh while we
                // were waiting for the mutex. Compare the token that was on the
                // failed request against the token currently in DataStore.
                val currentToken  = TodoPreferenceStore.getAuthToken(context = context).firstOrNull()
                val requestToken  = response.request
                    .header("Authorization")
                    ?.removePrefix("Bearer ")

                if (currentToken != null && currentToken != requestToken) {
                    // Token was already refreshed — retry with the new one.
                    return@withLock response.request.newBuilder()
                        .header("Authorization", "Bearer $currentToken")
                        .build()
                }

                // ── Refresh attempt ───────────────────────────────────────────
                val newToken = tryRefreshToken()

                if (newToken != null) {
                    response.request.newBuilder()
                        .header("Authorization", "Bearer $newToken")
                        .build()
                } else {
                    // Refresh failed permanently — clear session and force login.
                    TodoPreferenceStore.clearAll(context = context)
                    null   // Returning null cancels the request with a 401.
                }
            }
        }
    }

    /**
     * Calls the refresh endpoint with up to [MAX_REFRESH_RETRIES] attempts.
     *
     * Retry policy:
     * - **Retries**: [IOException] (network/timeout), 5xx server errors
     * - **No retry**: 401 or 403 from the refresh endpoint (invalid/expired refresh token)
     * - **No retry**: any other 4xx (client error, no point retrying)
     *
     * @return the new access token on success, or `null` on permanent failure.
     */
    private suspend fun tryRefreshToken(): String? {
        val refreshToken = TodoPreferenceStore.getRefreshToken(context = context).firstOrNull()
            ?: return null   // No refresh token stored — cannot refresh.

        repeat(MAX_REFRESH_RETRIES) { attempt ->
            try {
                val refreshResponse = api.get().refreshAccessToken(
                    mapOf("refresh_token" to refreshToken)
                )

                when {
                    refreshResponse.isSuccessful -> {
                        val body = refreshResponse.body() ?: return null
                        // Persist the new access token.
                        // Pass refreshToken only when the backend returns one
                        // (refresh-token rotation). Null keeps the existing token.
                        TodoPreferenceStore.setAuthToken(
                           context = context,
                            token = body.accessToken
                        )
                        return body.accessToken
                    }

                    refreshResponse.code() == 401 ||
                            refreshResponse.code() == 403 -> {
                        // Refresh token is invalid or expired.
                        // No point retrying — return null immediately.
                        return null
                    }

                    refreshResponse.code() in 500..599 -> {
                        // Transient server error — back off and retry if attempts remain.
                        if (attempt < MAX_REFRESH_RETRIES - 1) {
                            kotlinx.coroutines.delay(exponentialBackoff(attempt))
                        }
                    }

                    else -> {
                        // Any other error (4xx etc.) — non-recoverable.
                        return null
                    }
                }
            } catch (e: IOException) {
                // Network error or timeout — retry if attempts remain.
                if (attempt == MAX_REFRESH_RETRIES - 1) return null
                kotlinx.coroutines.delay(exponentialBackoff(attempt))
            }
        }

        return null   // All retry attempts exhausted.
    }

    /**
     * Exponential backoff: 500 ms → 1 s → 2 s, capped at 4 s.
     */
    private fun exponentialBackoff(attempt: Int): Long =
        (500L * (1 shl attempt)).coerceAtMost(4_000L)
}