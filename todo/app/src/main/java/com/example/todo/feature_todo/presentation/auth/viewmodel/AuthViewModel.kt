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
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.use_case.AuthUseCases
import com.example.todo.feature_todo.domain.use_case.SignupResult
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import com.example.todo.feature_todo.domain.model.LoginRequest
import com.example.todo.feature_todo.domain.use_case.LoginUseCase
import com.example.todo.feature_todo.presentation.auth.AuthEvent
import com.example.todo.feature_todo.presentation.auth.AuthState
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
    private val authUseCases: AuthUseCases,
    private val loginUseCase: LoginUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _state = MutableStateFlow(AuthState())
    val state: StateFlow<AuthState> = _state.asStateFlow()

    private val _triggerLogin = sharedFlowWithReplay1<LoginRequest>()

    init {
        viewModelScope.launch {
            TodoPreferenceStore.getUserIdFlow(context).collectLatest { userId ->
                _state.update { it.copy(userId = userId ?: 0L) }
            }
        }

        collectUseCaseFlow<LoginRequest, LoginResult>(
            trigger = _triggerLogin,
            useCase = { payload -> loginUseCase(payload) },
            onLoading = {
                _state.update { it.copy(isLoading = true) }
            },
            onSuccess = { result -> onLoginSuccess(result) },
            onError = { message ->
                _state.update { it.copy(isLoading = false, error = message) }
                onUiEvent(UiEvent.ShowSnackBar)
            }
        )
    }

    sealed class UiEvent {
        data object BackButton : UiEvent()
        data object ShowSnackBar : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow


    private val _isSignupSuccess = MutableStateFlow<Boolean>(false)
    val isSignupSuccess: StateFlow<Boolean> = _isSignupSuccess

    fun onUiEvent(event: UiEvent) {
        viewModelScope.launch {
            when (event) {
                UiEvent.BackButton -> {
                    _uiEventFlow.emit(UiEvent.BackButton)
                }

                UiEvent.ShowSnackBar -> {
                    _uiEventFlow.emit(UiEvent.ShowSnackBar)
                }
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

    private fun onRegisterClick() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            if (_state.value.password != _state.value.confirmPassword) {
                _state.update { it.copy(isLoading = false, error = "Passwords do not match") }
                return@launch
            }

            when (val result = authUseCases.firebaseSignUpWithEmailAndPassword(
                _state.value.email,
                _state.value.password
            )) {
                is SignupResult.Success -> {
                    _state.update { it.copy(isLoading = false, email = "", password = "", confirmPassword = "") }
                    _isSignupSuccess.emit(true)
                }

                is SignupResult.Error -> {
                    _state.update { it.copy(isLoading = false, error = result.message ?: "An unexpected error occurred") }
                }
            }
        }
    }

    private fun onLoginSuccess(result: LoginResult) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = false) }
            result.let { data ->
                TodoPreferenceStore.setUserId(context, data.id)
                TodoPreferenceStore.setUserName(context, data.name)
                TodoPreferenceStore.setUserEmail(context, data.email)
                TodoPreferenceStore.setUserProfileImage(context, data.imageUrl)
                TodoPreferenceStore.setIsLoggedIn(context, true)
                TodoPreferenceStore.setAuthToken(context, data.accessToken)
                TodoPreferenceStore.setRefreshToken(context, data.refreshToken)
            }

        }
    }
}