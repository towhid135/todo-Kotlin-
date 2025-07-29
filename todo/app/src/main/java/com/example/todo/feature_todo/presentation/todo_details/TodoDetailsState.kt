package com.example.todo.feature_todo.presentation.todo_details

import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryColor
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Work

data class TodoDetailsState(
    val todo: TodoItem? = TodoItem(
        id = "",
        title = "",
        description = "",
        priority = Priority.LOW,
        category = Category(
            id = "1",
            title = Todoz.Work.name,
            bgColor = CategoryColor.PERU.colorCode,
            icon = Todoz.Work.name.lowercase()
        ),
        completed = false,
        createdAt = 0L,
        dueDate = 0L,
    ),
    val user: User = User(
        id = "",
        name = "",
        email = ""
    ),
    val isLoading: Boolean = false,
    val error: String? = null
)