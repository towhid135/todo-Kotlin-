package com.example.todo.feature_todo.presentation.home.components

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.home.view_model.HomeViewModel
import com.example.todo.feature_todo.presentation.todo_details.view_model.TodoDetailsViewModel
import com.example.todo.navigation_graph.graphs.HomeNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScaffold() {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val todoDetailsViewModel:TodoDetailsViewModel = hiltViewModel()
    val snackBarHostState = remember { SnackbarHostState() }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            TodoBottomTab(navController = navController)
        },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { innerPadding ->
        HomeNavGraph(navController, homeViewModel,todoDetailsViewModel)
    }


}




