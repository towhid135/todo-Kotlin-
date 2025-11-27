package com.example.todo.feature_todo.presentation.home

import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryColor
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Work

data class HomeScreenState(
    val newTodo:TodoItem = TodoItem(
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
        createdAt = System.currentTimeMillis(),
        dueDate = System.currentTimeMillis(),
    ),
    val todoItems:List<TodoItem> = emptyList(),
    val user:User = User(),
    val todoItemOrder:TodoItemOrder = TodoItemOrder.Time(SortingDirection.DESC),
    val isLoading:Boolean = false,
    val error:String? = null
)