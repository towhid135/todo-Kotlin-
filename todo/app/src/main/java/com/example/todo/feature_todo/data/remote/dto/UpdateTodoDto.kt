package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UpdateTodoRequestDto(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("category_id")
    val categoryId: Long,

    @SerializedName("priority")
    val priority: Int,

    @SerializedName("completed")
    val completed: Boolean,

    @SerializedName("dueDate")
    val dueDate: String
)

data class UpdateTodoResponseDto(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("category_id")
    val categoryId: Long,

    @SerializedName("priority")
    val priority: Int,

    @SerializedName("completed")
    val completed: Boolean,

    @SerializedName("dueDate")
    val dueDate: String
)
