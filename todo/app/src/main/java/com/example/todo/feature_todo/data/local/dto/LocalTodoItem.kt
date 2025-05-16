package com.example.todo.feature_todo.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority

@Entity(tableName = "todo")
data class LocalTodoItem(
    @PrimaryKey
    val id: String,
    val createdAt:Long,
    val dueDate:Long,
    val title:String,
    val  description:String,
    val completed:Boolean,
    val category: Category,
    val priority: Priority,
)
