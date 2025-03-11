package com.example.todo.feature_todo.presentation.todo_new_update

import androidx.compose.ui.focus.FocusState

sealed class TodoNewUpdateEvent {
    object SaveTodo: TodoNewUpdateEvent()
    object DeleteTodo: TodoNewUpdateEvent()
    object ToggleArchived: TodoNewUpdateEvent()
    object ToggleCompleted: TodoNewUpdateEvent()
    object Back:TodoNewUpdateEvent()
    data class OnChangeTitle(val title: String): TodoNewUpdateEvent()
    data class OnchangeDescription(val description: String): TodoNewUpdateEvent()
    data class ChangedTitleFocus(val focusState:FocusState): TodoNewUpdateEvent()
    data class ChangedDescriptionFocus(val focusState: FocusState): TodoNewUpdateEvent()
}