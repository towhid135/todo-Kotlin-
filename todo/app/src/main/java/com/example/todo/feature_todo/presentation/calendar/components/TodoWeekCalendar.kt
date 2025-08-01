package com.example.todo.feature_todo.presentation.calendar.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todo.core.presentation.components.DateItem
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Arrowleft
import com.example.todo.ui.icons.todoz.Arrowright
import com.example.todo.ui.icons.todoz.Edit
import com.example.todo.ui.theme.LocalTheme
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import kotlinx.coroutines.launch
import java.time.LocalDate

@Composable
fun TodoWeekCalendar(
    modifier: Modifier = Modifier,
    initialDate: LocalDate = LocalDate.now(),
    selectedDate: LocalDate = LocalDate.now(),
    dateOnClick: (LocalDate) -> Unit,
){
    val theme = LocalTheme.current
    val scope = rememberCoroutineScope()
    val today = LocalDate.now()

    val calendarState = rememberWeekCalendarState(
        startDate = today.minusDays(500),
        endDate = today.plusDays(500),
        firstVisibleWeekDate = initialDate,
//        firstDayOfWeek =
    )

    WeekCalendarHeader(
        monthName = "February",
        year = "2023",
        onLeftArrowClick = {scope.launch{
            val targetDate = calendarState.firstVisibleWeek.days.first().date.minusWeeks(1)
            calendarState.animateScrollToWeek(targetDate)
        }},
        onRightArrowClick = {
            scope.launch {
                val targetDate = calendarState.firstVisibleWeek.days.first().date.plusWeeks(1)
                calendarState.animateScrollToWeek(targetDate)
            }
        }

    )
    WeekCalendar(
        modifier = modifier.background(color = theme.colors.backgroundSecondary).fillMaxWidth().padding(vertical = 20.dp),
        state = calendarState,
        calendarScrollPaged = true,
        dayContent = {day ->
            DateItem(modifier = Modifier.padding(horizontal = 10.dp),date = day.date,today = today)
        }
    )

}