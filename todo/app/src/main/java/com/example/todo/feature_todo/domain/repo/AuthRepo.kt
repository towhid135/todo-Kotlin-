package com.example.todo.feature_todo.domain.repo

sealed class AuthResponse {
    data class Success(val data: Boolean) : AuthResponse()
    data class Error(val message: String) : AuthResponse()
}


interface AuthRepo {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): AuthResponse
}