package com.example.todo.feature_todo.presentation.todo_details

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.todo_details.view_model.TodoDetailsViewModel
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Cross
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun TodoDetailsScreen(
    navigateUp: () -> Unit,
    todoDetailsViewModel: TodoDetailsViewModel = hiltViewModel()
) {
    val theme = LocalTheme.current
    val uiEventFlow = todoDetailsViewModel.uiEventFlow

    LaunchedEffect(key1 = true) {
        uiEventFlow.collectLatest { event ->
            when (event) {
                TodoDetailsViewModel.UiEvent.BackButton -> navigateUp()
            }
        }
    }

    Scaffold(
        topBar = {
            TodoListScreenTopAppBar(
                title = TodoListStrings.DETAILS,
                leftIcon = Icons.AutoMirrored.Filled.ArrowBackIos,
                onLeftIconClick = { todoDetailsViewModel.onUiEvent(TodoDetailsViewModel.UiEvent.BackButton) })
        },

        ) { innnerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = theme.colors.backgroundPrimary)
        ) {

        }
    }

}