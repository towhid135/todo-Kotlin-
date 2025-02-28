package com.example.todo.feature_todo.presentation.todo_new_update

sealed class TodoNewUpdateEvent {
    data object SaveTodo: TodoNewUpdateEvent()
    data object DeleteTodo: TodoNewUpdateEvent()
    data object ToggleArchived: TodoNewUpdateEvent()
    data object ToggleCompleted: TodoNewUpdateEvent()
}