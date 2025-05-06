package com.example.todo.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType

@Composable
fun CategoryBox(
    category: Category,
    type: CategoryBoxType,
    onPress: () -> Unit
) {
    val height = when (type) {
        CategoryBoxType.RECTANGLE -> 40.dp
        CategoryBoxType.SQUARE -> 100.dp

    }
    val width = when (type) {
        CategoryBoxType.RECTANGLE -> 100.dp
        CategoryBoxType.SQUARE -> 100.dp
    }
    Row(
        modifier = Modifier
            .height(height)
            .width(width)
            .clip(RoundedCornerShape(5.dp))
            .background(color = category.bgColor.colorCode),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {

    }
}