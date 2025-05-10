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

@Composable
fun BottomTabItem(
    icon: ImageVector,
    title: String,
    selected: Boolean,
    onClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = icon,contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = title, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant, fontFamily = FontFamily.SansSerif)
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

