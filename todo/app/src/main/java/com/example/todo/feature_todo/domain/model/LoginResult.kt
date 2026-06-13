package com.example.todo.feature_todo.domain.model

data class LoginResult(
    val id: Long,
    val name: String,
    val email: String,
    val isVerified: Boolean,
    val imageUrl: String,
    val accessToken: String,
    val refreshToken: String,
)
