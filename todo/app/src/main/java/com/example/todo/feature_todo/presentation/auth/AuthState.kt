package com.example.todo.feature_todo.presentation.auth

data class AuthState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
    val isPasswordVisible: Boolean = false
)
