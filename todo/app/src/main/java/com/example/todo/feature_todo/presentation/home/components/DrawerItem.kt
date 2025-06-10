package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme

@Composable
fun DrawerItem(
    text: String = "",
    isChecked: Boolean = false,
) {
    val theme = LocalTheme.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = text,
            color = theme.colors.textPrimary,
            fontSize = 18.sp,
            lineHeight = 18.sp
        )
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = theme.colors.iconPrimary
            )
        }
    }
}

@Preview
@Composable
fun DrawerItemPreview() {
    TodoTheme {
        DrawerItem(
            text = "Sort Item",
            isChecked = true
        )
    }
}