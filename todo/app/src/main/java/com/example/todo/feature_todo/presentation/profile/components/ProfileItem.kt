package com.example.todo.feature_todo.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.todo.ui.icons.todoz.Arrowright
import com.example.todo.ui.icons.todoz.Setting
import com.example.todo.ui.theme.LocalTheme

@Composable
fun ProfileItem(
    title:String,
    icon: ImageVector,
    onPress: () -> Unit
){
    val theme = LocalTheme.current
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(24.dp,24.dp),
                imageVector = icon,
                contentDescription = null,
                tint = theme.colors.iconPrimary
            )
            Text(text = title, fontSize = 16.sp, color = theme.colors.textPrimary, fontFamily = FontFamily.SansSerif)

        }
        Icon(
            modifier = Modifier.size(24.dp,24.dp),
            imageVector = Todoz.Arrowright,
            contentDescription = null,
            tint = theme.colors.iconPrimary
        )
    }
}

@Preview
@Composable
fun ProfileItemPreview() {
    val theme = LocalTheme.current
    ProfileItem(
        title = "Settings",
        icon = Todoz.Setting,
        onPress = { /* Handle click */ }
    )
}