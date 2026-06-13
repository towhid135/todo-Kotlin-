package com.example.todo.feature_todo.data.remote.dto

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.google.gson.annotations.SerializedName

// Note: keep date fields as ISO strings — Gson doesn't parse java.time types by default.
// We'll parse them in the mapper into ZonedDateTime.

data class TodoItemDto(
    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("userId")
    val userId: Long? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("category")
    val category: CategoryDto? = null,

    @SerializedName("priority")
    val priority: Int? = null,

    @SerializedName("completed")
    val completed: Boolean? = null,

    // Use ISO-8601 string for dates — e.g. "2026-06-10T02:29:44.501717728Z"
    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("dueDate")
    val dueDate: String? = null
)


data class CategoryDto(
    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("bgColor")
    val bgColor: String? = null,

    @SerializedName("icon")
    val icon: String? = null
)
