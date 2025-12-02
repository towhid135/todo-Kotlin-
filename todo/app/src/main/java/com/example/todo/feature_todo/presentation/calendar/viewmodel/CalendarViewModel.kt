package com.example.todo.feature_todo.presentation.calendar.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoResult
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.calendar.CalendarEvent
import com.example.todo.feature_todo.presentation.calendar.CalendarState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import getEndOfDayMillis
import getStartOfDayMillis
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _state = mutableStateOf(CalendarState())
    val state = _state
    private val errorHandler = CoroutineExceptionHandler {_ , e ->
        e.printStackTrace()
        _state.value = _state.value.copy(message = e.message ?: "date was todos fetching error")
    }

    init {
        fetchTodosForSelectedDate(_state.value.selectedDate)
    }



    fun onEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.OnDateSelect -> {
                _state.value = _state.value.copy(selectedDate = event.date)
                fetchTodosForSelectedDate(dueDate = event.date)
            }
        }
    }

    private fun fetchTodosForSelectedDate(
        dueDate: LocalDate,

    ) {
        _state.value = _state.value.copy(isTodosLoading = true)
        val startAt = getStartOfDayMillis(dueDate)
        val endAt = getEndOfDayMillis(dueDate)
        viewModelScope.launch(dispatcher + errorHandler) {
            val userId = TodoPreferenceStore.getUserId(context).firstOrNull() ?: ""
            when(val todosRes = todoUseCases.getTodosByDateRange(userId,startAt,endAt)){
                is TodoResult.Success -> {
                    _state.value = _state.value.copy(todos = todosRes.todoItems, isTodosLoading = false)
                }
                is TodoResult.Error -> {
                    _state.value = _state.value.copy(message = todosRes.message, isTodosLoading = false)
                }
            }
        }
    }
}