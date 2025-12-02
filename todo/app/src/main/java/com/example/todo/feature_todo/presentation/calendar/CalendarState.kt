package com.example.todo.feature_todo.presentation.calendar

import com.example.todo.feature_todo.domain.model.TodoItem
import java.time.LocalDate

data class CalendarState(
    val todos: List<TodoItem>? = null,
    val selectedDate: LocalDate = LocalDate.now(),
    val message: String = "",
    val isTodosLoading: Boolean = false
)