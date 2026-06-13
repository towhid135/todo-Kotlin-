package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

data class LoginResponseData(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,

    @SerializedName("is_verified")
    val isVerified: Boolean,

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("access_token_expiry")
    val accessTokenExpiry: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("refresh_token_expiry")
    val refreshTokenExpiry: String
)
