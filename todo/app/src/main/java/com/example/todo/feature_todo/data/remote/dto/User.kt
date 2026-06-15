package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("email")
    val email: String = "",

    @SerializedName("phone_number")
    val phoneNumber: String = "",

    @SerializedName("image_url")
    val profileImageUrl: String = ""
)

data class UpdateUserRequestDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("image_url")
    val imageUrl: String
)
