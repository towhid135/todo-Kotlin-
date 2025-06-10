package com.example.todo.feature_todo.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.ui.theme.LocalTheme

@Composable
fun ProfileScreen() {
    val theme = LocalTheme.current
    Column(
        modifier = Modifier.fillMaxSize().background(color = theme.colors.backgroundPrimary)
    ) {

    }
}