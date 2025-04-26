package com.example.todo.feature_todo.domain.model

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority

data class TodoItem(
    val id: String,
    val createdAt:Long,
    val title:String,
    val  description:String,
    val completed:Boolean,
    val category: Category,
    val priority: Priority
)
