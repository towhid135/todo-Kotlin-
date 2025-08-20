package com.example.todo.feature_todo.presentation.calendar

import java.time.LocalDate

data class CalendarState(
    val selectedDate: LocalDate = LocalDate.now()
)