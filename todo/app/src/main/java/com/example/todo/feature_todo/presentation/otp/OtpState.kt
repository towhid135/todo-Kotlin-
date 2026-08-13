package com.example.todo.feature_todo.presentation.otp

data class OtpState(
    val email: String = "",
    val otp: String = "",
    val isLoading: Boolean = false,
    val error: String = ""
)
