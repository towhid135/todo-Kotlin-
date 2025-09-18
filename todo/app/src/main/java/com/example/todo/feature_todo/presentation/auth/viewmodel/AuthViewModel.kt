package com.example.todo.feature_todo.presentation.auth.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.auth.AuthEvent
import com.example.todo.feature_todo.presentation.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = mutableStateOf(AuthState())
    val state: State<AuthState> = _state

    sealed class UiEvent {
        data object BackButton : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow

    private val _isAuthenticated = MutableStateFlow<Boolean>(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated

    fun onUiEvent(event: UiEvent) {
        when (event) {
            UiEvent.BackButton -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.BackButton)
                }
            }
        }
    }

    fun onEvent(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnEmailChange -> {
                _state.value = _state.value.copy(email = event.email)
            }

            is AuthEvent.OnPasswordChange -> {
                _state.value = _state.value.copy(password = event.password)
            }

            is AuthEvent.OnConfirmPasswordChange -> {
                _state.value = _state.value.copy(confirmPassword = event.confirmPassword)
            }

            AuthEvent.OnLoginClick -> {
                //TODO: Implement login logic
                viewModelScope.launch {
                    _isAuthenticated.emit(true)
                }
            }

            AuthEvent.OnRegisterClick -> {
                //TODO: Implement register logic
            }
        }
    }
}