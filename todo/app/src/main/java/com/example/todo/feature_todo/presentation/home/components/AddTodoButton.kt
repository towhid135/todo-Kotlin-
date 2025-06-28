package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.ui.theme.LocalTheme

@Composable
fun AddTodoButton(onAddButtonPress: () -> Unit) {
    val theme = LocalTheme.current
    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 20.dp
    FloatingActionButton(
        modifier = Modifier.padding(bottom = bottomPadding),
        onClick = onAddButtonPress,
        shape = CircleShape,
        containerColor = theme.colors.primary,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ContentDescriptions.ADD_TODO,
            tint = theme.colors.iconPrimary
        )
    }
}