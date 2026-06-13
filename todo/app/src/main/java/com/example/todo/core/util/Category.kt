package com.example.todo.core.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val id: Long,
    val title: String,
    val bgColor: String,
    val icon: String,
    val isSelected: Boolean = false
)