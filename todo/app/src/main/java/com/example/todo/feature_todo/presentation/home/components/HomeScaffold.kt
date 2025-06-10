package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.feature_todo.presentation.home.HomeViewModel
import com.example.todo.navigation_graph.graphs.HomeNavGraph
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.launch


@Composable
fun HomeScaffold() {
    val theme = LocalTheme.current
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state = homeViewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(state.todoItemOrder, onOrderChange = { order ->
                homeViewModel.onEvent(HomeScreenEvent.Sort(order))
            })
        }
    ) {
        Scaffold(
            floatingActionButton = {
                AddTodoButton(onAddButtonPress = {
                    //method to navigate to details
                })
            },
            topBar = { TodoListScreenTopAppBar { scope.launch { drawerState.open() } } },
            bottomBar = {
                TodoBottomTab(navController = navController)
            },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ){ innerPadding ->
            HomeNavGraph(navController,innerPadding)
        }
    }
}




