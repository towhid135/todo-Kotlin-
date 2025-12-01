package com.example.todo.feature_todo.presentation.calendar.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.calendar.CalendarEvent
import com.example.todo.feature_todo.presentation.calendar.CalendarState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor (
    private val todoUseCases: TodoUseCases
):ViewModel() {
    private val _state = mutableStateOf(CalendarState())
    val state = _state

    fun onEvent(event: CalendarEvent){
        when(event){
            is CalendarEvent.OnDateSelect -> {
                _state.value = _state.value.copy(selectedDate = event.date)
            }
        }
    }

    private fun fetchTodosForSelectedDate(){

    }
}