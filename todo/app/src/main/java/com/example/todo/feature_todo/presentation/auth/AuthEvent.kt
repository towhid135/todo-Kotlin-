package com.example.todo.feature_todo.presentation.auth

sealed class AuthEvent {
    data class OnEmailChange(val email: String) : AuthEvent()
    data class OnPasswordChange(val password: String) : AuthEvent()
    data class OnConfirmPasswordChange(val confirmPassword: String) : AuthEvent()
    data object OnLoginClick : AuthEvent()
    data object OnRegisterClick : AuthEvent()
}