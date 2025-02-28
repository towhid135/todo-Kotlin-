package com.example.todo.feature_todo.presentation.todo_new_update

import com.example.todo.feature_todo.domain.model.TodoItem

data class TodoNewUpdateState(
    val todo:TodoItem? = null,
    val isLoading:Boolean = true,
    val error:String? = null
)
