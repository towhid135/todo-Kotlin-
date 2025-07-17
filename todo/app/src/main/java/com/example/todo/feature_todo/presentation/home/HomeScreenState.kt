package com.example.todo.feature_todo.presentation.home

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder

data class HomeScreenState(
    val newTodo:TodoItem = TodoItem(
        id = "",
        title = "",
        description = "",
        priority = Priority.LOW,
        category = Category(
            id = "1",
            title = "Work",
            bgColor = "0xFFCC4173",
            icon = "calendar" // Replace with an appropriate ImageVector
        ),
        completed = false,
        createdAt = 0L,
        dueDate = 0L,
    ),
    val todoItems:List<TodoItem> = emptyList(),
    val user:User = User(
        id = "",
        name = "",
        email = ""
    ),
    val todoItemOrder:TodoItemOrder = TodoItemOrder.Time(SortingDirection.DESC),
    val isLoading:Boolean = true,
    val error:String? = null
)