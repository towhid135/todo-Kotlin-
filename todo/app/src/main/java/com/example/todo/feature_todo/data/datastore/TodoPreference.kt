package com.example.todo.feature_todo.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "todoUserDataStore")

object TodoPreferenceStore {
    private val USER_ID = longPreferencesKey("user_id")
    private val USER_NAME = stringPreferencesKey("user_name")
    private val USER_EMAIL = stringPreferencesKey("user_email")
    private val USER_PROFILE_IMAGE = stringPreferencesKey("user_image")
    private val IS_FRESH_APP_USER = booleanPreferencesKey("is_fresh_app_user")
    private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    private val AUTH_TOKEN = stringPreferencesKey("auth_token")
    private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")

    suspend fun setUserId(context: Context, userId: Long) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = userId
        }
    }

     fun getUserIdFlow(context: Context): Flow<Long?> {
        val userIdStringKey = stringPreferencesKey("user_id")
        return context.dataStore.data.map { preferences ->
            // Try to read as Long first. If the stored value was previously saved as a String
            // (older versions or migration issues), fall back to parsing the string.
            try {
                val longVal = preferences[USER_ID]
                if (longVal != null) return@map longVal
            } catch (e: ClassCastException) {
                // ignore and try string fallback
            }

            // Fallback: try reading stored string value and parse to Long
            val strVal = try {
                preferences[userIdStringKey]
            } catch (e: Exception) {
                null
            }
            strVal?.toLongOrNull()
        }
    }

     suspend fun getUserId(context: Context): Long? {
        val userIdStringKey = stringPreferencesKey("user_id")
        return context.dataStore.data.map { preferences ->
            try {
                val longVal = preferences[USER_ID]
                if (longVal != null) return@map longVal
            } catch (e: ClassCastException) {
                // ignore
            }

            val strVal = try { preferences[userIdStringKey] } catch (e: Exception) { null }
            strVal?.toLongOrNull()
        }.firstOrNull()
    }

    suspend fun setUserName(context: Context, userName: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = userName
        }
    }

    fun getUserName(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_NAME]
        }
    }

    suspend fun setUserEmail(context: Context, userEmail: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL] = userEmail
        }
    }

    fun getUserEmail(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_EMAIL]
        }
    }

    suspend fun setUserProfileImage(context: Context, imageUrl: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_PROFILE_IMAGE] = imageUrl
        }
    }

    fun getUserProfileImage(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[USER_PROFILE_IMAGE]
        }
    }

    suspend fun setIsFreshAppUser(context: Context, isFreshUser: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_FRESH_APP_USER] = isFreshUser
        }
    }

    fun getIsFreshAppUser(context: Context): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[IS_FRESH_APP_USER]
        }
    }

    suspend fun setIsLoggedIn(context: Context, isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
        }
    }

    fun getIsLoggedIn(context: Context): Flow<Boolean?> {
        return context.dataStore.data.map { preferences ->
            preferences[IS_LOGGED_IN]
        }
    }

    suspend fun setAuthToken(context: Context, token: String) {
        context.dataStore.edit { preferences ->
            preferences[AUTH_TOKEN] = token
        }
    }

    fun getAuthToken(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[AUTH_TOKEN]
        }
    }

    suspend fun setRefreshToken(context: Context, token: String) {
        context.dataStore.edit { preferences ->
            preferences[REFRESH_TOKEN] = token
        }
    }

    fun getRefreshToken(context: Context): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }
    }



    suspend fun resetPreferences(context: Context) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = ""
            preferences[USER_EMAIL] = ""
            preferences[USER_PROFILE_IMAGE] = ""
            preferences[IS_FRESH_APP_USER] = true
            preferences[IS_LOGGED_IN] = false
            preferences[AUTH_TOKEN] = ""
            preferences[REFRESH_TOKEN] = ""
        }
    }

    suspend fun clearAll(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}