package com.example.todo.feature_todo.presentation.profile

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.CloudinaryManager
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.domain.use_case.UserResult
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.firstOrNull
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

    init {
        viewModelScope.launch {
            try{
                _state.value = _state.value.copy(isProfileGetApiLoading = true)
                val userEmail = TodoPreferenceStore.getUserEmail(context).firstOrNull() ?: ""
                val userResponse = todoUseCases.getUserByMail(email = userEmail)
                when(userResponse){
                    is UserResult.Success -> {
                        userResponse.user.let { user ->
                            TodoPreferenceStore.setUserId(context, user.id)
                            TodoPreferenceStore.setUserName(context, user.name)
                            TodoPreferenceStore.setUserProfileImage(context, user.profileImageUrl)
                            _state.value = _state.value.copy(
                                name = user.name,
                                email = user.email,
                                profileImageUrl = user.profileImageUrl,
                            )
                        }
                    }
                    is UserResult.Error -> {
                        Log.e("ProfileViewModel", "Error fetching user: ${userResponse.message}")
                    }
                }

            }catch (e: Exception){
                Log.e("ProfileViewModel", "An error occurred while fetching user data", e)
            }finally {
                _state.value = _state.value.copy(isProfileGetApiLoading = false)
            }

        }
    }

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
            is ProfileEvent.OnSubmitProfileChanges -> onSubmitProfileChanges()
            is ProfileEvent.OnNameChange -> onNameChange(event.name)
            is ProfileEvent.OnEmailChange -> onEmailChange(event.email)
        }
    }

    private fun onLogoutConfirmed() {
        viewModelScope.launch {
            todoUseCases.clearAllTodoItems()
            TodoPreferenceStore.resetPreferences(context)
        }
    }

    private fun onNameChange(name: String){
        _state.value = _state.value.copy(name)
    }

    private fun onEmailChange(email: String){
        _state.value = _state.value.copy(email = email)
    }

    private fun onEditProfileImage(selectedProfileImageUri: Uri) {
        _state.value = _state.value.copy(
            profileImageUri = selectedProfileImageUri,
            profileImageUrl = selectedProfileImageUri.toString()
        )
    }

    private fun onSubmitProfileChanges() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            try {
                if (_state.value.profileImageUri != null) {
                    val profileImageUrlFromCloudinary = CloudinaryManager.uploadImageToCloudinary(
                        _state.value.profileImageUri!!,
                        context
                    )

                    profileImageUrlFromCloudinary?.let { url ->
                        _state.value = _state.value.copy(
                            profileImageUrl = url
                        )
                    }
                }

                val userId = TodoPreferenceStore.getUserId(context).firstOrNull() ?: ""
                val userEmail = TodoPreferenceStore.getUserEmail(context).firstOrNull() ?: ""
                TodoPreferenceStore.setUserName(context, _state.value.name)
                TodoPreferenceStore.setUserProfileImage(context, _state.value.profileImageUrl)

                val user = User(
                    id = userId,
                    name = _state.value.name,
                    email = userEmail,
                    profileImageUrl = _state.value.profileImageUrl
                )

                if(userId.isNotEmpty() && userEmail.isNotEmpty()){
                    todoUseCases.updateUser(
                        email = userEmail,
                        user = user
                    )
                }else{
                    Log.e("ProfileViewModel", "User ID or Email is empty, cannot update user profile")
                }


            } catch (e: Exception) {
                Log.e("ProfileViewModel", "An error occurred during profile update", e)
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }

}