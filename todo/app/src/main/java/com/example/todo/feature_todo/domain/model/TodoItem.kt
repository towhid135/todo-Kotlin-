package com.example.todo.feature_todo.domain.model

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import java.time.ZonedDateTime

data class TodoItem(
    val id: Long,
    val userId: Long,
    val title: String,
    val description: String,
    val category: Category,
    val priority: Int,
    val completed: Boolean,
    val createdAt: ZonedDateTime,
    val dueDate: ZonedDateTime
)
