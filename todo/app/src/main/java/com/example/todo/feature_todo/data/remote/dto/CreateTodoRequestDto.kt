package com.example.todo.feature_todo.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Request DTO for POST /api/v1/todos.
 *
 * Matches the Go Todo struct exactly:
 *  - category_id (int64, not a nested object)
 *  - dueDate as UTC RFC3339 string (Go time.Time JSON parsing requires this)
 *
 * Note: createdAt is set server-side, so we don't send it.
 */
data class CreateTodoRequestDto(
    @SerializedName("userId")
    val userId: Long,

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

    // Must be UTC RFC3339 format: "2026-06-13T00:00:00Z"
    // Go's time.Time JSON parser rejects timezone names like [Asia/Dhaka]
    @SerializedName("dueDate")
    val dueDate: String
)
