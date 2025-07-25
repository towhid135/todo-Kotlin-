package com.example.todo.feature_todo.presentation.auth

sealed class AuthEvent {
    data class onEmailChange(val email: String) : AuthEvent()
    data class onPasswordChange(val password: String) : AuthEvent()
    data class onConfirmPasswordChange(val confirmPassword: String) : AuthEvent()
    data object onLoginClick : AuthEvent()
    data object onRegisterClick : AuthEvent()
}