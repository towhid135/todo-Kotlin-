package com.example.todo.feature_todo.presentation.home

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder

data class HomeScreenState(
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