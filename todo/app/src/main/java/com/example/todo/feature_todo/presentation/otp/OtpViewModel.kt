package com.example.todo.feature_todo.presentation.otp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(OtpState())
    val state: StateFlow<OtpState> = _state.asStateFlow()

    private val _uiEventFlow = MutableSharedFlow<OtpUiEvent>()
    val uiEventFlow: SharedFlow<OtpUiEvent> = _uiEventFlow

    fun onActionEvent(event: OtpActionEvent) {
        when (event) {
            is OtpActionEvent.OnOtpChange -> onOtpChange(event.otp)
            OtpActionEvent.OnSubmitClick -> onSubmitClick()
            OtpActionEvent.OnBackClick -> onBackClick()
        }
    }

    private fun onOtpChange(otp: String) {
        _state.update { it.copy(otp = otp) }
    }

    private fun onSubmitClick() {
        submitOtp()
    }

    private fun onBackClick() {
        viewModelScope.launch {
            _uiEventFlow.emit(OtpUiEvent.NavigateBack)
        }
    }

    private fun submitOtp() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            // TODO: Replace with real OTP verification API call
            kotlinx.coroutines.delay(2000)
            _state.update { it.copy(isLoading = false) }
            _uiEventFlow.emit(OtpUiEvent.NavigateToNextScreen)
        }
    }
}
