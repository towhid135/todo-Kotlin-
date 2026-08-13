package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignupRequestDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

data class SignupResponseDto(
    @SerializedName("message")
    val message: String,
    @SerializedName("email")
    val email: String
)
