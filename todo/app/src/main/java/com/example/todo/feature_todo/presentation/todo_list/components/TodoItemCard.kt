package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.presentation.components.ArchiveButton
import com.example.todo.core.presentation.components.CompleteButton
import com.example.todo.core.presentation.components.DeleteButton
import com.example.todo.core.presentation.components.getTodoColors
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.ui.theme.TodoTheme

@Composable
fun TodoItemCard(
    todo: TodoItem,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit,
    onCompleteClick: () -> Unit,
    onArchiveClick: () -> Unit,
    onCardClick: () -> Unit
) {
    val todoColors = getTodoColors(todo)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        onClick = onCardClick,
        colors = CardDefaults.cardColors(containerColor = todoColors.backgroundColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompleteButton(onCompleteClick, todoColors.checkColor, todo.completed)
            Text(
                text = todo.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = todoColors.textColor,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, bottom = 16.dp, end = 8.dp),
            text = todo.description,
            style = MaterialTheme.typography.bodyLarge,
            color = todoColors.textColor,
            fontSize = 16.sp,
            maxLines = 12,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Preview
@Composable
fun TodoItemCardPreview() {
    TodoTheme {
        TodoItemCard(
            TodoItem(
                title = "This a title",
                description = "This description is dummy description, created to show a preview.",
                timestamp = 11234565,
                completed = true,
                archived = false,
                id = 0
            ),
            onDeleteClick = {},
            onCardClick = {},
            onArchiveClick = {},
            onCompleteClick = {}
        )
    }
}