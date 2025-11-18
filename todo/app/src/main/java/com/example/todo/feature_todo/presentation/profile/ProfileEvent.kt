package com.example.todo.feature_todo.presentation.profile

import android.net.Uri

sealed class ProfileEvent {
    object Logout: ProfileEvent()
    data class EditProfileImage(val selectedProfileImageUri: Uri): ProfileEvent()
    data class OnNameChange(val name: String): ProfileEvent()
    data class OnEmailChange(val email: String): ProfileEvent()
    object OnSubmitProfileChanges: ProfileEvent()
}