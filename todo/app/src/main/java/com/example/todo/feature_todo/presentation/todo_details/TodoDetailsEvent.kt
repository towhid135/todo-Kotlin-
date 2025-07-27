package com.example.todo.feature_todo.presentation.todo_details

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem

sealed class TodoDetailsEvent {
    data class OnDeleteTodo(val user: User,val todo:TodoItem):TodoDetailsEvent()
}