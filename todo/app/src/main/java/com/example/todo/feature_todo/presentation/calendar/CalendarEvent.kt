package com.example.todo.feature_todo.presentation.calendar

import java.time.LocalDate

sealed class CalendarEvent {
    data class OnDateSelect(val date: LocalDate):CalendarEvent()
}