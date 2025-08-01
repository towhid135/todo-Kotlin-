package com.example.todo.feature_todo.presentation.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.CalenderScreenStrings
import com.example.todo.feature_todo.presentation.calendar.components.TodoWeekCalendar
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.theme.LocalTheme

@Composable
fun CalendarScreen() {
    val theme = LocalTheme.current
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

            TodoWeekCalendar() { }

        }
    }
}