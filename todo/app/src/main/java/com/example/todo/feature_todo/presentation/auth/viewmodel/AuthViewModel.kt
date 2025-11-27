package com.example.todo.feature_todo.presentation.auth.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.AuthUseCases
import com.example.todo.feature_todo.domain.use_case.SignInResult
import com.example.todo.feature_todo.domain.use_case.SignupResult
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.domain.use_case.UserResult
import com.example.todo.feature_todo.presentation.auth.AuthEvent
import com.example.todo.feature_todo.presentation.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    sealed class UiEvent {
        data object BackButton : UiEvent()
        data object ShowSnackBar : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow

    val userId = TodoPreferenceStore.getUserId(context)

    private val _isSignupSuccess = MutableStateFlow<Boolean>(false)
    val isSignupSuccess: StateFlow<Boolean> = _isSignupSuccess

    fun onUiEvent(event: UiEvent) {
        when (event) {
            UiEvent.BackButton -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.BackButton)
                }
            }

            UiEvent.ShowSnackBar -> {
                viewModelScope.launch {
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
        _state.value = _state.value.copy(email)
    }

    private fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    private fun onConfirmPassChange(confirmPass: String) {
        _state.value = _state.value.copy(confirmPassword = confirmPass)
    }

    private fun onEyeButtonPress() {
        _state.value = _state.value.copy(isPasswordVisible = !_state.value.isPasswordVisible)
    }

    private fun onLoginClick() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            when (val result = authUseCases.firebaseLoginWithEmailAndPassword(
                _state.value.email,
                _state.value.password
            )) {
                is SignInResult.Success -> {
                     onLoginSuccess(_state.value.email)
                    _state.value = _state.value.copy(isLoading = false, email = "", password = "")
                }

                is SignInResult.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                    onUiEvent(UiEvent.ShowSnackBar)
                }
            }
        }
    }

    private fun onRegisterClick() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            if (_state.value.password != _state.value.confirmPassword) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = "Passwords do not match"
                )
                return@launch
            }

            when (val result = authUseCases.firebaseSignUpWithEmailAndPassword(
                _state.value.email,
                _state.value.password
            )) {
                is SignupResult.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        email = "",
                        password = "",
                        confirmPassword = ""
                    )
                    _isSignupSuccess.emit(true)
                }

                is SignupResult.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
            }
        }
    }

    private fun onLoginSuccess(userEmail: String){
        viewModelScope.launch {
            val userResponse = todoUseCases.getUserByMail(email = userEmail.split("@")[0])
            when (userResponse) {
                is UserResult.Success -> {
                    userResponse.user.let { user ->
                        TodoPreferenceStore.setUserId(context, user.id)
                        TodoPreferenceStore.setUserName(context, user.name)
                        TodoPreferenceStore.setUserEmail(context, user.email)
                        TodoPreferenceStore.setUserProfileImage(context, user.profileImageUrl)
                        TodoPreferenceStore.setIsLoggedIn(context, true)
                    }
                }

                is UserResult.Error -> {
                    Log.e("ProfileViewModel", "Error fetching user: ${userResponse.message}")
                }
            }
        }
    }
}