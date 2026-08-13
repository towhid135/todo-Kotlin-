package com.example.todo.feature_todo.presentation.auth.viewmodel

sealed class OtpEvent {
    data class OnOtpChange(val otp: String) : OtpEvent()
    object OnSubmitClick : OtpEvent()
    object ShowSnackBar : OtpEvent()
}
