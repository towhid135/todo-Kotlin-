package com.example.todo.feature_todo.presentation.profile

import android.net.Uri

data class ProfileState(
    val userId: Long = 0L,
    val name: String = "",
    val email: String = "",
    val profileImageUrl: String = "",
    val profileImageUri: Uri? = null,
    val isProfileUpdateLoading: Boolean = false,
    val isProfileGetApiLoading: Boolean = false,
    val isLogoutLoading: Boolean = false,
    val errorMessage: String? = null
)
