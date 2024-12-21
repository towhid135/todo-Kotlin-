package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.TodoListStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreenTopAppBar(onMenuButtonPress: () -> Unit){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = TodoListStrings.TODO_LIST,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {},
        actions = {
            IconButton(onClick = onMenuButtonPress) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = ContentDescriptions.SORTING_MENU)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
            scrolledContainerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    )
}