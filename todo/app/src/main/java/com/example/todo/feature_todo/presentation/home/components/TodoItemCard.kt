package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.navigation_graph.routes.Screen
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.core.util.FormattedDate
import java.time.ZonedDateTime

@Composable
fun TodoItemCard(
    todo: TodoItem,
    onCompleteClick: () -> Unit,
    onCardClick: (route: String) -> Unit
) {
    val theme = LocalTheme.current

    // convert ZonedDateTime dueDate to epoch millis for the helper
    val dueDateMillis = try {
        todo.dueDate.toInstant().toEpochMilli()
    } catch (_: Exception) {
        System.currentTimeMillis()
    }

    val dueDate: FormattedDate = com.example.todo.core.util.timeStampToDate(dueDateMillis)

    // map Int priority to Priority enum expected by PriorityBox
    val priorityEnum: Priority = when (todo.priority) {
        1 -> Priority.LOW
        2 -> Priority.MEDIUM
        3 -> Priority.HIGH
        else -> Priority.MEDIUM
    }

    Card(
        onClick = { onCardClick(Screen.TodoDetails.route + "?todoId=${todo.id}") },
        colors = CardDefaults.cardColors(containerColor = theme.colors.secondary),
    ) {
        Row(
            modifier = Modifier
                .height(90.dp)
                .width(340.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            RadioButton(
                todo.completed, onClick = onCompleteClick, colors = RadioButtonDefaults.colors(
                    selectedColor = theme.colors.iconPrimary,
                    unselectedColor = theme.colors.iconPrimary
                )
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = todo.title,
                    fontSize = 16.sp,
                    color = theme.colors.textPrimary,
                    fontFamily = FontFamily.SansSerif,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier
                        .padding(end = 10.dp, bottom = 5.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = "Due: ${dueDate.dayNumber}/${dueDate.monthNumber}/${dueDate.year}",
                        fontSize = 14.sp,
                        color = theme.colors.textPrimary,
                        fontFamily = FontFamily.SansSerif
                    )
                    CategoryBox(
                        category = todo.category,
                        type = CategoryBoxType.RECTANGLE,
                        onPress = { /* Handle click */ }
                    )
                    com.example.todo.feature_todo.presentation.home.components.PriorityBox(priority = priorityEnum)
                }

            }

        }
    }
}

@Preview
@Composable
fun TodoItemCardPreview() {
    val mockTodoItem = TodoItem(
        id = 1L,
        userId = 0L,
        title = "Complete Homework",
        description = "Finish math and science homework",
        category = Category(
            id = 1L,
            title = "Work",
            bgColor = "0xFFCC4173",
            icon = "work"
        ),
        priority = 3,
        completed = false,
        createdAt = ZonedDateTime.now(),
        dueDate = ZonedDateTime.now().plusDays(1),
    )

    TodoTheme {
        TodoItemCard(
            todo = mockTodoItem,
            onCompleteClick = { /* Handle complete click */ },
            onCardClick = { /* Handle card click */ }
        )
    }
}
