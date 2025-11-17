package com.example.todo.feature_todo.presentation.profile

sealed class ProfileEvent {
    object Logout: ProfileEvent()
    data class EditProfileImage(val selectedProfileImageUri: String): ProfileEvent()
}