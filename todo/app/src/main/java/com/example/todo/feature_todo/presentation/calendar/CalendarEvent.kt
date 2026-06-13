package com.example.todo.feature_todo.presentation.calendar

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import java.time.LocalDate

sealed class CalendarEvent {
    data class OnDateSelect(val date: LocalDate):CalendarEvent()
    data class OnToggleComplete(val user: User, val todoItem: TodoItem): CalendarEvent()
    object OnPullToRefresh: CalendarEvent()
}