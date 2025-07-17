package com.example.todo.core.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(val id:String,val title: String,val isSelected:Boolean = false, val bgColor: String,val icon: String)
