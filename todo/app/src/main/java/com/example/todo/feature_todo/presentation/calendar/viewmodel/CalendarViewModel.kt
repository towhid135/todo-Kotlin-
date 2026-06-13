package com.example.todo.feature_todo.presentation.calendar.viewmodel

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.calendar.CalendarEvent
import com.example.todo.feature_todo.presentation.calendar.CalendarState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

import com.example.todo.core.util.getEndOfDayMillis
import com.example.todo.core.util.getStartOfDayMillis

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val _state = MutableStateFlow(CalendarState())
    val state: StateFlow<CalendarState> = _state.asStateFlow()
    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.update { it.copy(message = e.message ?: "date was todos fetching error") }
    }

    init {
        viewModelScope.launch {
            val userId = TodoPreferenceStore.getUserIdFlow(context).firstOrNull()
            _state.update { current -> current.copy(user = current.user.copy(id = userId)) }
            _state.value.user.id?.let {
                fetchTodosForSelectedDate(
                    userId = it,
                    dueDate = _state.value.selectedDate
                )
            }
        }
    }


    fun onEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.OnDateSelect -> onDateSelect(event.date)
            is CalendarEvent.OnToggleComplete -> onToggleComplete(event.user, event.todoItem)
            CalendarEvent.OnPullToRefresh -> {
                _state.value.user.id?.let {
                    fetchTodosForSelectedDate(
                        it,
                        _state.value.selectedDate,
                        isPullToRefresh = true
                    )
                }
            }
        }
    }

    private fun fetchTodosForSelectedDate(
        userId: Long,
        dueDate: LocalDate,
        isPullToRefresh: Boolean = false
    ) {
        _state.update {
            if (isPullToRefresh) it.copy(isPullToRefresh = true) else it.copy(isTodosLoading = true)
        }
        val startAt = getStartOfDayMillis(dueDate)
        val endAt = getEndOfDayMillis(dueDate)
        viewModelScope.launch(dispatcher + errorHandler) {

        }
    }

    private fun onDateSelect(date: LocalDate) {
        _state.update { it.copy(selectedDate = date) }
        _state.value.user.id?.let {
            fetchTodosForSelectedDate(userId = it, dueDate = date)
        }
    }

    private fun onToggleComplete(user: User, todoItem: TodoItem) {

    }
}