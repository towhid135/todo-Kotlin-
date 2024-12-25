package com.example.todo.feature_todo.presentation.todo_list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.R
import androidx.compose.ui.res.painterResource
import com.example.todo.feature_todo.presentation.todo_list.components.AddTodoButton
import com.example.todo.feature_todo.presentation.todo_list.components.DrawerContent
import com.example.todo.feature_todo.presentation.todo_list.components.TodoItemList
import com.example.todo.feature_todo.presentation.todo_list.components.TodoListScreenTopAppBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    val backgroundImage = if(isPortrait){
        R.drawable.background_portrait
    }else{
        R.drawable.background_landscape
    }

    LaunchedEffect(key1 = true) {
        viewModel.getTodoItems()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(state.todoItemOrder, onOrderChange = {order ->
            viewModel.onEvent(TodoListEvent.Sort(order))
        }) }
    ) {
        Scaffold(
            floatingActionButton = {
                AddTodoButton(onAddButtonPress = {
                    //TODO: Navigate to Add Todo Screen
                })
            },
            topBar = { TodoListScreenTopAppBar { scope.launch { drawerState.open() } }},
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { padding ->
            TodoItemList(
                backgroundImage = painterResource(id = backgroundImage),
                todoItems = state.todoItems,
                isLoading = state.isLoading,
                error = state.error,
                onPullToRefresh = {viewModel.getTodoItems()}
            )

        }
    }
}




