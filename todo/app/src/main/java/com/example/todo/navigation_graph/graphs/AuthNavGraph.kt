package com.example.todo.navigation_graph.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.auth.Login
import com.example.todo.feature_todo.presentation.auth.Signup
import com.example.todo.navigation_graph.routes.GraphRoutes
import com.example.todo.navigation_graph.routes.Screen

@Composable
fun AuthNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = GraphRoutes.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Signup.route) {
            Signup(onLoginClick = {
                navController.navigate(Screen.Login.route)
            })
        }
        composable(route = Screen.Login.route) {
            Login(onRegisterClick = {
                navController.navigate(Screen.Signup.route)
            })
        }
    }
}