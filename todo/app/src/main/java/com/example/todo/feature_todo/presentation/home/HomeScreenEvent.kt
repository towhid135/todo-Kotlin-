package com.example.todo.feature_todo.presentation.home

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.TodoItemOrder

sealed class HomeScreenEvent {
    data class ToggleCompleted(val user:User,val todo:TodoItem):HomeScreenEvent()
    data class TodoCardPress(val todo: TodoItem): HomeScreenEvent()
    data class Sort(val todoItemOrder: TodoItemOrder):HomeScreenEvent()

}