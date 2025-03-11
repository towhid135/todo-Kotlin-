package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.todo.core.util.ContentDescriptions

@Composable
fun AddTodoButton(onAddButtonPress: () -> Unit) {
    FloatingActionButton(
        onClick = onAddButtonPress,
        shape = FloatingActionButtonDefaults.shape,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ContentDescriptions.ADD_TODO,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}