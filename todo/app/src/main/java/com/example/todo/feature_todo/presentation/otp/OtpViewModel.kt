package com.example.todo.feature_todo.presentation.otp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import com.example.todo.feature_todo.domain.use_case.VerifyOtpUseCase
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
class OtpViewModel @Inject constructor(
    private val verifyOtpUseCase: VerifyOtpUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(OtpState())
    val state: StateFlow<OtpState> = _state.asStateFlow()

    private val _uiEventFlow = MutableSharedFlow<OtpUiEvent>()
    val uiEventFlow: SharedFlow<OtpUiEvent> = _uiEventFlow

    private val _triggerVerifyOtp = sharedFlowWithReplay1<Pair<String, String>>()

    init {
        savedStateHandle.get<String>("email")?.let { email ->
            _state.update { it.copy(email = email) }
        }

        collectUseCaseFlow(
            trigger = _triggerVerifyOtp,
            useCase = { (email, otp) -> verifyOtpUseCase(email, otp) },
            onLoading = ::onVerifyOtpLoading,
            onSuccess = ::onVerifyOtpSuccess,
            onError = ::onVerifyOtpError
        )
    }

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
        val currentEmail = _state.value.email
        val currentOtp = _state.value.otp

        if (currentOtp.isBlank()) {
            _state.update { it.copy(error = "Please enter OTP") }
            viewModelScope.launch {
                _uiEventFlow.emit(OtpUiEvent.ShowSnackBar)
            }
            return
        }

        _triggerVerifyOtp.tryEmit(Pair(currentEmail, currentOtp))
    }

    private fun onBackClick() {
        viewModelScope.launch {
            _uiEventFlow.emit(OtpUiEvent.NavigateBack)
        }
    }

    private fun onVerifyOtpLoading() {
        _state.update { it.copy(isLoading = true, error = "") }
    }

    private fun onVerifyOtpSuccess(unit: Unit) {
        _state.update { it.copy(isLoading = false, error = "") }
        viewModelScope.launch {
            _uiEventFlow.emit(OtpUiEvent.NavigateToNextScreen)
        }
    }

    private fun onVerifyOtpError(message: String) {
        _state.update { it.copy(isLoading = false, error = message) }
        viewModelScope.launch {
            _uiEventFlow.emit(OtpUiEvent.ShowSnackBar)
        }
    }
}
