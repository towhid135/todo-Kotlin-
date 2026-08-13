package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VerifyOtpRequestDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("otp")
    val otp: String
)
