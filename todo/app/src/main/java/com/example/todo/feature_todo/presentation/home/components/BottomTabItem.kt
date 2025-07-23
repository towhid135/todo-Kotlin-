package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.theme.LocalTheme

@Composable
fun BottomTabItem(
    icon: ImageVector,
    title: String,
    selected: Boolean,
    onClick: () -> Unit
){
    val theme = LocalTheme.current
    val selectedIconColor = if (selected) theme.colors.primary else theme.colors.iconPrimary
    val selectedTextColor = if (selected) theme.colors.primary else theme.colors.textPrimary
    Column(
        modifier = Modifier.clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(modifier = Modifier.size(20.dp),imageVector = icon,contentDescription = null, tint = selectedIconColor)
        Text(text = title, fontSize = 10.sp, color = selectedTextColor, fontFamily = FontFamily.SansSerif)
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

