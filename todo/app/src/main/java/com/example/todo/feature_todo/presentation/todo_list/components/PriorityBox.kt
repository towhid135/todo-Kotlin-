package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.Priority
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Flag
import com.example.todo.ui.theme.TodoTheme

@Composable
fun PriorityBox(priority: Priority) {
    val borderColor = when (priority) {
        Priority.LOW -> Color.Green
        Priority.MEDIUM -> Color.Yellow
        Priority.HIGH -> Color.Red
    }

    Row(
        modifier = Modifier
            .border(1.dp, borderColor, RoundedCornerShape(5.dp))
            .padding(horizontal = 5.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(14.dp, 14.dp)
                .padding(top = 1.dp),
            imageVector = Todoz.Flag,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
        )

        Text(
            text = priority.value,
            fontSize = 10.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontFamily = FontFamily.SansSerif
        )

    }
}

@Preview
@Composable
fun PriorityBoxPreview() {
    TodoTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            PriorityBox(priority = Priority.LOW)
            PriorityBox(priority = Priority.MEDIUM)
            PriorityBox(priority = Priority.HIGH)
        }
    }
}