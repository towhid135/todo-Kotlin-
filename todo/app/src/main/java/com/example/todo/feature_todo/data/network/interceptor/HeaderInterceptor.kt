package com.example.todo.feature_todo.data.network.interceptor

import android.content.Context
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    @ApplicationContext private val context: Context,
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // We use runBlocking because Interceptors are synchronous.
        // This is safe as OkHttp runs this on a background thread.
        val token: String? = runBlocking {
            TodoPreferenceStore.getAuthToken(context = context).firstOrNull()
        }

        val request = chain.request().newBuilder().apply {
            token?.let { addHeader("Authorization", "Bearer $it") }
        }.build()

        return chain.proceed(request)
    }
}