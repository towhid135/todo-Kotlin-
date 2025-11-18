package com.example.todo.feature_todo.presentation.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.TodoProfileStrings
import com.example.todo.feature_todo.presentation.profile.ProfileViewModel
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Logout
import com.example.todo.ui.theme.LocalTheme

@Composable
fun LogoutButton(
    onClick: () -> Unit
) {
    val theme = LocalTheme.current
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(25.dp),
            imageVector = Todoz.Logout,
            contentDescription = null,
            tint = theme.colors.error,
        )
        Text(
            text = TodoProfileStrings.LOG_OUT,
            fontSize = 14.sp,
            color = theme.colors.error,
            fontFamily = FontFamily.SansSerif,
        )
    }
}