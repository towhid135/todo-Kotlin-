package com.example.todo.feature_todo.presentation.home.components

import android.util.Log
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoDatePickerModal(
    initialSelectedDateMillis: Long?,
    showDatePicker: Boolean,
    toggleShowDatePicker: () -> Unit,
    onChangeDueDate: (dueDate: Long) -> Unit
) {
    if (showDatePicker) {
        val currentTimeMillis = initialSelectedDateMillis?.takeIf { it > 0L } ?: System.currentTimeMillis()
        // Get today's date at start of day (00:00)
        val todayMillis = LocalDate.now()
            .atStartOfDay(ZoneId.systemDefault())
            .toInstant()
            .toEpochMilli()



        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = currentTimeMillis,
            selectableDates = object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    return utcTimeMillis >= todayMillis
                }
            }
        )
        val hasSelectedDate = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                toggleShowDatePicker()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onChangeDueDate(datePickerState.selectedDateMillis ?: System.currentTimeMillis())
                        toggleShowDatePicker()
                    },
                    enabled = hasSelectedDate.value,
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = toggleShowDatePicker) { Text("Cancel") }
            },
        ) {
            DatePicker(
                state = datePickerState,
                modifier = Modifier.verticalScroll(rememberScrollState()),
            )
        }
    }
}