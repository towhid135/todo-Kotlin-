package com.example.todo.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.ui.theme.LocalTheme
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DateItem(
    modifier: Modifier= Modifier,
    date: LocalDate,
    selectedDate: LocalDate,
    onDateSelect: (LocalDate) -> Unit = {},
) {
    val theme = LocalTheme.current
    val dayName = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val dayNumber = date.dayOfMonth.toString()
    val isSelected = date == selectedDate

    val selectedDateBgColor = if (isSelected) theme.colors.backgroundPrimaryLight else theme.colors.backgroundTertiary

    Column(
        modifier = modifier
            .clickable { onDateSelect(date) }
            .size(40.dp, 50.dp)
            .background(selectedDateBgColor, shape = RoundedCornerShape(5.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dayName,
            fontSize = 10.sp,
            color = theme.colors.textPrimary,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = dayNumber,
            fontSize = 10.sp,
            color = theme.colors.textPrimary,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDateItem() {
    DateItem(date = LocalDate.now(), selectedDate = LocalDate.now())
}