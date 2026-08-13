package com.example.todo.feature_todo.presentation.auth.viewmodel

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.model.LoginRequest
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import com.example.todo.feature_todo.domain.use_case.LoginUseCase
import com.example.todo.feature_todo.domain.use_case.RegisterUseCase
import com.example.todo.feature_todo.presentation.auth.AuthEvent
import com.example.todo.feature_todo.presentation.auth.AuthState
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    private val _triggerLogin = sharedFlowWithReplay1<LoginRequest>()
    private val _triggerSignup = sharedFlowWithReplay1<SignupRequest>()

    init {
        viewModelScope.launch {
            TodoPreferenceStore.getUserIdFlow(context).collectLatest { userId ->
                _state.update { it.copy(userId = userId ?: 0L) }
            }
        }

        collectUseCaseFlow<LoginRequest, LoginResult>(
            trigger = _triggerLogin,
            useCase = { payload -> loginUseCase(payload) },
            onLoading = ::onLoginLoading,
            onSuccess = ::onLoginSuccess,
            onError = ::onLoginError
        )

        collectUseCaseFlow<SignupRequest, SignupResult>(
            trigger = _triggerSignup,
            useCase = { request -> registerUseCase(request) },
            onLoading = ::onSignupLoading,
            onSuccess = ::onSignupSuccess,
            onError = ::onSignupError
        )
    }

    sealed class UiEvent {
        data object BackButton : UiEvent()
        data object ShowSnackBar : UiEvent()
        data class NavigateToOtp(val email: String) : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow

    fun onUiEvent(event: UiEvent) {
        viewModelScope.launch {
            when (event) {
                UiEvent.BackButton -> _uiEventFlow.emit(UiEvent.BackButton)
                UiEvent.ShowSnackBar -> _uiEventFlow.emit(UiEvent.ShowSnackBar)
                is UiEvent.NavigateToOtp -> _uiEventFlow.emit(UiEvent.NavigateToOtp(event.email))
            }
        }
    }

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnEmailChange -> onEmailChange(event.email)
            is AuthEvent.OnPasswordChange -> onPasswordChange(event.password)
            is AuthEvent.OnConfirmPasswordChange -> onConfirmPassChange(event.confirmPassword)
            AuthEvent.OnEyeButtonPress -> onEyeButtonPress()
            AuthEvent.OnLoginClick -> onLoginClick()
            AuthEvent.OnRegisterClick -> onRegisterClick()
        }
    }

    private fun onEmailChange(email: String) {
        _state.update { it.copy(email = email) }
    }

    private fun onPasswordChange(password: String) {
        _state.update { it.copy(password = password) }
    }

    private fun onConfirmPassChange(confirmPass: String) {
        _state.update { it.copy(confirmPassword = confirmPass) }
    }

    private fun onEyeButtonPress() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    private fun onLoginClick() {
        _triggerLogin.tryEmit(
            LoginRequest(
                email = _state.value.email,
                password = _state.value.password
            )
        )
    }

    private fun onLoginLoading() {
        _state.update { it.copy(isLoading = true) }
    }

    private fun onLoginSuccess(result: LoginResult) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = false) }
            TodoPreferenceStore.setUserId(context, result.id)
            TodoPreferenceStore.setUserName(context, result.name)
            TodoPreferenceStore.setUserEmail(context, result.email)
            TodoPreferenceStore.setUserProfileImage(context, result.imageUrl)
            TodoPreferenceStore.setIsLoggedIn(context, true)
            TodoPreferenceStore.setAuthToken(context, result.accessToken)
            TodoPreferenceStore.setRefreshToken(context, result.refreshToken)
        }
    }

    private fun onLoginError(message: String) {
        _state.update { it.copy(isLoading = false, error = message) }
        onUiEvent(UiEvent.ShowSnackBar)
    }

    private fun onRegisterClick() {
        if (_state.value.password != _state.value.confirmPassword) {
            _state.update { it.copy(error = "Passwords do not match") }
            onUiEvent(UiEvent.ShowSnackBar)
            return
        }
        _state.update { it.copy(error = "") }
        _triggerSignup.tryEmit(
            SignupRequest(
                email = _state.value.email,
                password = _state.value.password
            )
        )
    }

    private fun onSignupLoading() {
        _state.update { it.copy(isLoading = true) }
    }

    private fun onSignupSuccess(result: SignupResult) {
        _state.update {
            it.copy(
                isLoading = false,
                signupEmail = result.email,
                error = "",
                password = "",
                confirmPassword = ""
            )
        }
        onUiEvent(UiEvent.NavigateToOtp(result.email))
    }

    private fun onSignupError(message: String) {
        _state.update { it.copy(isLoading = false, error = message) }
        onUiEvent(UiEvent.ShowSnackBar)
    }
}