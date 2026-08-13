package com.example.todo.feature_todo.presentation.auth.viewmodel

data class OtpState(
    val otp: String = "",
    val isLoading: Boolean = false,
    val error: String = ""
)
