package com.example.todo.feature_todo.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.feature_todo.presentation.home.components.TodoItemList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LaunchedEffect(key1 = state.user.id) {
        state.user.id.takeIf { it.isNotEmpty() }?.let {
            viewModel.getTodoItems(userId = it)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TodoItemList(
            todoItems = state.todoItems,
            user = state.user,
            isLoading = state.isLoading,
            error = state.error,
            onPullToRefresh = {
                viewModel.getTodoItems(state.user.id)
            },
            onEvent = { event ->
                viewModel.onEvent(event)
            }
        )
        LoadingModal(isLoading = state.isLoading)
    }
}




