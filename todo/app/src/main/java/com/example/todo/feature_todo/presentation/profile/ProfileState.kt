package com.example.todo.feature_todo.presentation.profile

import android.net.Uri

data class ProfileState(
    val name: String = "",
    val email: String = "",
    val profileImageUrl: String = "",
    val profileImageUri: Uri? = null,
    val isLoading: Boolean = false,
    val isProfileGetApiLoading: Boolean = false
)
