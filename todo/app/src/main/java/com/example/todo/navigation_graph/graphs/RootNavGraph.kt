package com.example.todo.navigation_graph.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.presentation.auth.viewmodel.AuthViewModel
import com.example.todo.feature_todo.presentation.home.components.HomeScaffold
import com.example.todo.navigation_graph.routes.GraphRoutes

@Composable
fun RootNavGraph(authViewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val context = LocalContext.current

    // collect the current user id from DataStore as state
    val currentUserId by TodoPreferenceStore.getUserIdFlow(context).collectAsState(initial = null)

    // if a valid user id exists (non-null and not 0), start at HOME, otherwise AUTH
    val startDestination = if (currentUserId != null && currentUserId != 0L) {
        GraphRoutes.HOME
    } else {
        GraphRoutes.AUTH
    }

    NavHost(
        navController = navController,
        route = GraphRoutes.ROOT,
        startDestination = startDestination
    ) {
        composable(route = GraphRoutes.HOME) {
            HomeScaffold()
        }
        composable(route = GraphRoutes.AUTH) {
            AuthNavGraph(authViewModel)
        }
    }
}