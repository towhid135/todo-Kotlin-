package com.example.todo.feature_todo.presentation.otp

sealed class OtpUiEvent {
    object ShowSnackBar : OtpUiEvent()
    object NavigateToNextScreen : OtpUiEvent()
    object NavigateBack : OtpUiEvent()
}

sealed class OtpActionEvent {
    data class OnOtpChange(val otp: String) : OtpActionEvent()
    object OnSubmitClick : OtpActionEvent()
    object OnBackClick : OtpActionEvent()
}
