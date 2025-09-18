package com.example.todo.navigation_graph.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.auth.viewmodel.AuthViewModel
import com.example.todo.feature_todo.presentation.home.components.HomeScaffold
import com.example.todo.navigation_graph.routes.GraphRoutes

@Composable
fun RootNavGraph(authViewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val isAuthenticated by authViewModel.isAuthenticated.collectAsState()
    NavHost(
        navController = navController,
        route = GraphRoutes.ROOT,
        startDestination = if(isAuthenticated) GraphRoutes.HOME else GraphRoutes.AUTH
    ) {
        composable(route = GraphRoutes.HOME) {
            HomeScaffold()
        }
        composable(route = GraphRoutes.AUTH) {
            AuthNavGraph(authViewModel)
        }
    }
}