package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType
import com.example.todo.core.util.CategoryColor
import com.example.todo.ui.icons.IconsNamed
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme

@Composable
fun CategoryBox(
    category: Category,
    type: CategoryBoxType,
    onPress: () -> Unit
) {
    val theme = LocalTheme.current
    val height = when (type) {
        CategoryBoxType.RECTANGLE -> 30.dp
        CategoryBoxType.SQUARE -> 64.dp

    }
    val width = when (type) {
        CategoryBoxType.RECTANGLE -> 85.dp
        CategoryBoxType.SQUARE -> 64.dp
    }
    val iconHeight = when(type){
        CategoryBoxType.RECTANGLE -> 15.dp
        CategoryBoxType.SQUARE -> 32.dp
    }
    val iconWidth = when (type) {
        CategoryBoxType.RECTANGLE -> 15.dp
        CategoryBoxType.SQUARE -> 32.dp
    }
    Row(
        modifier = Modifier
            .height(height)
            .width(width)
            .clip(RoundedCornerShape(5.dp))
            .background(color = Color(category.bgColor.removePrefix("0x").toLong(radix = 16))),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        ) {
        Icon(
            modifier = Modifier.size(iconWidth,iconHeight),
            imageVector = Todoz.IconsNamed[category.icon] ?: Todoz.University,
            contentDescription = null,
            tint = theme.colors.iconPrimary,
        )
        if(type == CategoryBoxType.RECTANGLE) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = category.title, fontSize = 10.sp, color = theme.colors.textPrimary, fontFamily = FontFamily.SansSerif)
        }
    }
}

@Preview
@Composable
fun CategoryBoxPreview() {
    val mockCategory = Category(
        id = "1",
        title = "Work",
        bgColor = "0xFFCC4173",
        icon = "calendar" // Replace with an appropriate ImageVector
    )

    TodoTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
            CategoryBox(
                category = mockCategory,
                type = CategoryBoxType.RECTANGLE,
                onPress = { /* Handle click */ }
            )
            CategoryBox(
                category = mockCategory,
                type = CategoryBoxType.SQUARE,
                onPress = { /* Handle click */ }
            )
        }
    }
}

