package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.TodoListStrings
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Filter
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreenTopAppBar(onMenuButtonPress: () -> Unit){
    val theme = LocalTheme.current
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = TodoListStrings.INDEX,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                color = theme.colors.textPrimary
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuButtonPress) {
                Icon(imageVector = Todoz.Filter, contentDescription = ContentDescriptions.SORTING_MENU)
            }
        },
        actions = {
            Column(
                modifier = Modifier.background(theme.colors.iconPrimary, CircleShape).size(30.dp)
            ) {

            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = theme.colors.backgroundPrimary,
            scrolledContainerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = theme.colors.iconPrimary,
            titleContentColor = theme.colors.textPrimary,
            actionIconContentColor = theme.colors.iconPrimary
        ),
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    )
}