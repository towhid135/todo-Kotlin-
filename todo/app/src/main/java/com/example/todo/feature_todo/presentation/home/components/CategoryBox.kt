package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.todo.ui.icons.IconsNamed
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.icons.todoz.Work
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme

@Composable
fun CategoryBox(
    category: Category,
    type: CategoryBoxType,
    onPress: (category: Category) -> Unit
) {
    val theme = LocalTheme.current
    // Helper to safely parse color strings from the backend. Supports formats like:
    // "#RRGGBB", "#AARRGGBB", "0xAARRGGBB" and "RRGGBB". Falls back to theme primary color.
    fun parseColorString(raw: String?): Color {
        if (raw.isNullOrBlank()) return theme.colors.primary
        val cleaned = raw.trim().removePrefix("0x").removePrefix("#")
        val hex = when (cleaned.length) {
            6 -> "FF$cleaned" // add opaque alpha
            8 -> cleaned
            else -> return theme.colors.primary
        }

        return try {
            Color(hex.toLong(radix = 16))
        } catch (_: Exception) {
            theme.colors.primary
        }
    }

    val height = when (type) {
        CategoryBoxType.RECTANGLE -> 30.dp
        CategoryBoxType.SQUARE -> 70.dp

    }
    val width = when (type) {
        CategoryBoxType.RECTANGLE -> 85.dp
        CategoryBoxType.SQUARE -> 70.dp
    }
    val iconHeight = when (type) {
        CategoryBoxType.RECTANGLE -> 15.dp
        CategoryBoxType.SQUARE -> 32.dp
    }
    val iconWidth = when (type) {
        CategoryBoxType.RECTANGLE -> 15.dp
        CategoryBoxType.SQUARE -> 32.dp
    }
    if (type == CategoryBoxType.RECTANGLE) {
        Row(
            modifier = Modifier
                .height(height)
                .width(width)
                .clip(RoundedCornerShape(5.dp))
                .background(color = parseColorString(category.bgColor))
                .clickable { onPress(category) },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(iconWidth, iconHeight),
                imageVector = Todoz.IconsNamed[category.icon] ?: Todoz.University,
                contentDescription = null,
                tint = theme.colors.iconPrimary,
            )

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = category.title,
                fontSize = 10.sp,
                color = theme.colors.textPrimary,
                fontFamily = FontFamily.SansSerif
            )

        }

    } else {
        Column(
            modifier = Modifier
                .height(height + 20.dp)
                .width(width),
        ) {
            Column(
                modifier = Modifier
                    .height(height)
                    .width(width)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        color = parseColorString(category.bgColor)
                    )
                    .padding(5.dp)
                    .clickable { onPress(category) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(iconWidth, iconHeight),
                    imageVector = Todoz.IconsNamed[category.icon] ?: Todoz.University,
                    contentDescription = null,
                    tint = theme.colors.iconPrimary,
                )

                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = category.title,
                    fontSize = 10.sp,
                    color = theme.colors.textPrimary,
                    fontFamily = FontFamily.SansSerif
                )
            }

            if (category.isSelected) {
                Column(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .background(
                            theme.colors.primary,
                            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                        )
                        .height(3.dp)
                        .width(width),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Additional content can be added here if needed
                }
            }
        }

    }

}

@Preview
@Composable
fun CategoryBoxPreview() {
    val mockCategory = Category(
        id = 1L,
        title = "Work",
        bgColor = "0xFFCC4173",
        icon = Todoz.Work.name.lowercase(),
        isSelected = true
    )

    TodoTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            CategoryBox(
                category = mockCategory,
                type = CategoryBoxType.RECTANGLE,
                onPress = { /* Handle click */ }
            )
            CategoryBox(
                category = mockCategory,
                type = CategoryBoxType.SQUARE,
                onPress = { /* Handle click */ },
            )
        }
    }
}
