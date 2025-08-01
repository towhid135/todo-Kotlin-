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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Arrowleft
import com.example.todo.ui.icons.todoz.Arrowright
import com.example.todo.ui.theme.LocalTheme

@Composable
fun WeekCalendarHeader(
    monthName:String,
    year:String,
    onLeftArrowClick: () -> Unit,
    onRightArrowClick: () -> Unit
) {
    val theme = LocalTheme.current
    Column(
        modifier= Modifier.background(theme.colors.backgroundSecondary).fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .clickable {onLeftArrowClick()},
                imageVector = Todoz.Arrowleft,
                contentDescription = null,
                tint = theme.colors.iconPrimary,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = monthName,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                    color = theme.colors.textPrimary,
                )
                Text(
                    text = year,
                    fontWeight = FontWeight.Thin,
                    fontFamily = FontFamily.SansSerif,
                    color = theme.colors.textPrimary
                )
            }
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .clickable {onRightArrowClick()},
                imageVector = Todoz.Arrowright,
                contentDescription = null,
                tint = theme.colors.iconPrimary,
            )
        }
    }
}