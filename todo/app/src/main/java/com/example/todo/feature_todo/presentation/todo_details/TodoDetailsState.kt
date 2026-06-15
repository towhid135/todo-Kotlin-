package com.example.todo.feature_todo.presentation.todo_details

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem

data class TodoDetailsState(
    // Use null as the default for `todo` to avoid constructing an invalid TodoItem
    // here (type mismatches and required params). Callers already handle nulls.
    val todo: TodoItem? = null,
    val user: User = User(
        id = 0L,
        name = "",
        email = ""
    ),
    val isGetTodoByIdLoading: Boolean = false,
    val isUpdateTodoLoading: Boolean = false,
    val isDeleteTodoLoading: Boolean = false,
    val error: String? = null,
    val authToken: String? = null
)