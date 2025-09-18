package com.example.todo.feature_todo.data.repo

import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.feature_todo.domain.repo.AuthResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class AuthRepoImpl(
    private val auth: FirebaseAuth
) : AuthRepo {
    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String
    ): AuthResponse {
        return try {
            val authRes = auth.createUserWithEmailAndPassword(email, password).await()
            AuthResponse.Success(authRes.user != null)
        } catch (e: Exception) {
            AuthResponse.Error(e.message ?: "Unknown error occurred")
        }
    }
}


