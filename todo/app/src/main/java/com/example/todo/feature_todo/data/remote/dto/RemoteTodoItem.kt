package com.example.todo.feature_todo.data.remote.dto

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.google.gson.annotations.SerializedName

data class RemoteTodoItem (
    val id: String,
    val createdAt: Long,
    val dueDate: Long,
    val title: String,
    val description: String,
    val completed: Boolean,
    val category: Category,
    val priority: Priority
)