package com.example.todo.feature_todo.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.home.components.AddTodoButton
import com.example.todo.feature_todo.presentation.home.components.DrawerContent
import com.example.todo.feature_todo.presentation.home.components.TodoItemList
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Filter
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onCardClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    LaunchedEffect(key1 = state.user.id) {
        state.user.id.takeIf { it.isNotEmpty() }?.let {
            viewModel.getTodoItems(userId = it)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(state.todoItemOrder, onOrderChange = { order ->
                viewModel.onEvent(HomeScreenEvent.Sort(order))
            })
        }
    ) {
        Scaffold(
            floatingActionButton = {
                AddTodoButton(onAddButtonPress = {
                    //method to navigate to details
                })
            },
            topBar = {
                TodoListScreenTopAppBar(
                    title = TodoListStrings.HOME,
                    leftIcon = Todoz.Filter,
                    onLeftIconClick = { scope.launch { drawerState.open() } },
                    imageUrl = "dummyUrl"
                )
            },

            ) {
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
                    },
                    onCardClick = onCardClick
                )
                LoadingModal(isLoading = state.isLoading)
            }
        }
    }


}




