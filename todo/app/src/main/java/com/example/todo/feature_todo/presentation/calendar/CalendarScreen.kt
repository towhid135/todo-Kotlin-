package com.example.todo.feature_todo.presentation.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.core.util.CalenderScreenStrings
import com.example.todo.feature_todo.presentation.calendar.components.TodoWeekCalendar
import com.example.todo.feature_todo.presentation.calendar.viewmodel.CalendarViewModel
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.feature_todo.presentation.home.components.TodoItemList
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.theme.LocalTheme

@Composable
fun CalendarScreen(
    navigateToTodoDetails: (route: String) -> Unit,
    calendarViewModel: CalendarViewModel = hiltViewModel()
) {
    val theme = LocalTheme.current
    val state = calendarViewModel.state.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TodoListScreenTopAppBar(
                title = CalenderScreenStrings.CALENDER,
            )
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = theme.colors.backgroundPrimary)
                .padding(innerPaddingValues)
        ) {

            TodoWeekCalendar(
                selectedDate = state.selectedDate,
                onDateSelect = {calendarViewModel.onEvent(CalendarEvent.OnDateSelect(it))}
            )
            state.todos?.let {
                TodoItemList(
                    todoItems = state.todos,
                    isLoading = state.isPullToRefresh,
                    onPullToRefresh = { calendarViewModel.onEvent(CalendarEvent.OnPullToRefresh) },
                    onCompleteClick = {todoItem -> calendarViewModel.onEvent(CalendarEvent.OnToggleComplete(state.user,todoItem)) },
                    onCardClick = navigateToTodoDetails,
                    topPadding = 0.dp
                )
            }

        }
        LoadingModal(state.isTodosLoading)
    }
}