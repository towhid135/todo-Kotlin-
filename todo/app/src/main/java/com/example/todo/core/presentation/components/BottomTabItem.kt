package com.example.todo.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.theme.LocalTheme

@Composable
fun BottomTabItem(
    icon: ImageVector,
    title: String,
    selected: Boolean,
    onClick: () -> Unit
){
    val theme = LocalTheme.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = icon,contentDescription = null, tint = theme.colors.primary)
        Text(text = title, fontSize = 10.sp, color = theme.colors.primary, fontFamily = FontFamily.SansSerif)
    }
}


@Preview
@Composable
fun BottomTabItemPreview() {
    BottomTabItem(
        icon = Todoz.Home,
        title = "Home",
        selected = true,
        onClick = { /* Handle click */ }
    )
}

