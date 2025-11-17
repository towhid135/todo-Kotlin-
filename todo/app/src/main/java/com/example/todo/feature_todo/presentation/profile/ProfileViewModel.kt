package com.example.todo.feature_todo.presentation.profile

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    sealed class UiEvent {
        data object LogoutButton : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow

    fun onUiEvent(event: UiEvent) {
        when (event) {
            UiEvent.LogoutButton -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.LogoutButton)
                }
            }
        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.Logout -> onLogoutConfirmed()
            is ProfileEvent.EditProfileImage -> onEditProfileImage(event.selectedProfileImageUri)
        }
    }

    private fun onLogoutConfirmed() {
        viewModelScope.launch {
            todoUseCases.clearAllTodoItems()
            TodoPreferenceStore.resetPreferences(context)
        }
    }

    private fun onEditProfileImage(selectedProfileImageUri: String) {
        _state.value = _state.value.copy(
            profileImageUrl = selectedProfileImageUri
        )
    }
}