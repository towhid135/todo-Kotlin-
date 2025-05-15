package com.example.todo.core.presentation.components

import androidx.compose.foundation.background
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
import timeStampToDate

@Composable
fun DateItem(
    date: Long
) {
    val theme = LocalTheme.current
    val convertedDate = timeStampToDate(date)
    Column(
        modifier = Modifier
            .size(40.dp, 50.dp)
            .background(theme.colors.primary, shape = RoundedCornerShape(5.dp)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = convertedDate.dayName.uppercase(),
            fontSize = 10.sp,
            color = theme.colors.textPrimary,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = convertedDate.dayNumber.toString(),
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
    DateItem(date = System.currentTimeMillis())
}