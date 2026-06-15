package com.example.todo.feature_todo.presentation.profile

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.CloudinaryManager
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state.asStateFlow()

    sealed class UiEvent {
        data object LogoutButton : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow

    // Trigger for getUser flow — Unit since no input is needed
    private val _triggerGetUser = sharedFlowWithReplay1<Unit>()

    // Trigger for updateUser flow — Pair of (name, imageUrl)
    private val _triggerUpdateUser = sharedFlowWithReplay1<Pair<String, String>>()

    // Trigger for logout flow — Unit
    private val _triggerLogout = sharedFlowWithReplay1<Unit>()

    init {
        collectUseCaseFlow(
            trigger = _triggerGetUser,
            useCase = { todoUseCases.getUserUseCase() },
            onLoading = ::onGetUserLoading,
            onSuccess = ::onGetUserSuccess,
            onError = ::onGetUserError
        )

        collectUseCaseFlow(
            trigger = _triggerUpdateUser,
            useCase = { (name, imageUrl) -> todoUseCases.updateUserUseCase(name, imageUrl) },
            onLoading = ::onUpdateUserLoading,
            onSuccess = ::onUpdateUserSuccess,
            onError = ::onUpdateUserError
        )

        collectUseCaseFlow(
            trigger = _triggerLogout,
            useCase = { todoUseCases.logoutUseCase() },
            onLoading = ::onLogoutLoading,
            onSuccess = ::onLogoutSuccess,
            onError = ::onLogoutError
        )

        // Fetch user profile on startup
        viewModelScope.launch {
            _triggerGetUser.emit(Unit)
        }
    }

    // ─── getUser handlers ────────────────────────────────────────────

    private fun onGetUserLoading() {
        _state.update { it.copy(isProfileGetApiLoading = true, errorMessage = null) }
    }

    private fun onGetUserSuccess(user: User) {
        viewModelScope.launch {
            // Persist to local DataStore for offline/cached reads
            user.id?.let { TodoPreferenceStore.setUserId(context, it) }
            TodoPreferenceStore.setUserName(context, user.name)
            TodoPreferenceStore.setUserEmail(context, user.email)
            TodoPreferenceStore.setUserProfileImage(context, user.profileImageUrl)

            _state.update {
                it.copy(
                    userId = user.id ?: 0L,
                    isProfileGetApiLoading = false,
                    name = user.name,
                    email = user.email,
                    profileImageUrl = user.profileImageUrl
                )
            }
            Log.d("ProfileViewModel:","getUserSuccess $user")
        }
    }

    private fun onGetUserError(message: String) {
        Log.e("ProfileViewModel", "Error fetching user: $message")
        _state.update { it.copy(isProfileGetApiLoading = false, errorMessage = message) }
    }

    // ─── updateUser handlers ─────────────────────────────────────────

    private fun onUpdateUserLoading() {
        _state.update { it.copy(isProfileUpdateLoading = true, errorMessage = null) }
    }

    private fun onUpdateUserSuccess(user: User) {
        viewModelScope.launch {
            TodoPreferenceStore.setUserName(context, user.name)
            TodoPreferenceStore.setUserProfileImage(context, user.profileImageUrl)

            _state.update {
                it.copy(
                    isProfileUpdateLoading = false,
                    name = user.name,
                    profileImageUrl = user.profileImageUrl,
                    profileImageUri = null   // clear the local URI after successful upload
                )
            }
        }
    }

    private fun onUpdateUserError(message: String) {
        Log.e("ProfileViewModel", "Error updating user: $message")
        _state.update { it.copy(isProfileUpdateLoading = false, errorMessage = message) }
    }

    // ─── UI events ────────────────────────────────────────────────────

    fun onUiEvent(event: UiEvent) {
        when (event) {
            UiEvent.LogoutButton -> viewModelScope.launch {
                _uiEventFlow.emit(UiEvent.LogoutButton)
            }
        }
    }

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.Logout -> onLogoutConfirmed()
            is ProfileEvent.EditProfileImage -> onEditProfileImage(event.selectedProfileImageUri)
            is ProfileEvent.OnSubmitProfileChanges -> onSubmitProfileChanges()
            is ProfileEvent.OnNameChange -> onNameChange(event.name)
            is ProfileEvent.OnEmailChange -> onEmailChange(event.email)
        }
    }

    private fun onLogoutConfirmed() {
        _triggerLogout.tryEmit(Unit)
    }

    private fun onNameChange(name: String) {
        _state.update { it.copy(name = name) }
    }

    private fun onEmailChange(email: String) {
        _state.update { it.copy(email = email) }
    }

    private fun onEditProfileImage(selectedProfileImageUri: Uri) {
        _state.update {
            it.copy(
                profileImageUri = selectedProfileImageUri,
                profileImageUrl = selectedProfileImageUri.toString()
            )
        }
    }

    private fun onSubmitProfileChanges() {
        viewModelScope.launch {
            // Upload to Cloudinary first if a new local image was selected
            val finalImageUrl = if (_state.value.profileImageUri != null) {
                CloudinaryManager.uploadImageToCloudinary(
                    _state.value.profileImageUri!!,
                    context
                ) ?: _state.value.profileImageUrl
            } else {
                _state.value.profileImageUrl
            }

            _state.update { it.copy(profileImageUrl = finalImageUrl) }

            // Emit trigger to call the update API
            _triggerUpdateUser.emit(Pair(_state.value.name, finalImageUrl))
        }
    }

    private fun onLogoutLoading() {
        _state.update { it.copy(isLogoutLoading = true, errorMessage = null) }
    }

    private fun onLogoutSuccess(unit: Unit) {
        viewModelScope.launch {
            TodoPreferenceStore.resetPreferences(context)
            _state.update { it.copy(isLogoutLoading = false) }
        }
    }

    private fun onLogoutError(message: String) {
        Log.e("ProfileViewModel", "Error logging out: $message")
        _state.update { it.copy(isLogoutLoading = false, errorMessage = message) }
    }
}