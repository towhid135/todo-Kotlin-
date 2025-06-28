package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.TodoListStrings
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreenTopAppBar(
    title: String = "",
    leftIcon: ImageVector? = null,
    onLeftIconClick: () -> Unit = {},
    rightIcon: ImageVector? = null,
    imageUrl: String? = null,
    onRightIconClick: () -> Unit = {},
) {
    val theme = LocalTheme.current
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                color = theme.colors.textPrimary
            )
        },
        navigationIcon = {
            leftIcon?.let {
                IconButton(onClick = onLeftIconClick) {
                    Icon(
                        imageVector = leftIcon,
                        contentDescription = ContentDescriptions.SORTING_MENU
                    )
                }
            }
        },
        actions = {

            imageUrl?.let {
                Column(
                    modifier = Modifier
                        .background(theme.colors.iconPrimary, CircleShape)
                        .size(30.dp)
                ) {

                }
            }
            rightIcon?.let {
                IconButton(onClick = onRightIconClick) {
                    Icon(
                        imageVector = rightIcon,
                        contentDescription = ContentDescriptions.SORTING_MENU
                    )
                }
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