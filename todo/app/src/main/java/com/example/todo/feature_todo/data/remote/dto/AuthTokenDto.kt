package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RefreshAccessTokenDto(
    @SerializedName("access_token")
    val accessToken: String = "",
    @SerializedName("access_token_expiry")
    val accessTokenExpiry: String = ""
)