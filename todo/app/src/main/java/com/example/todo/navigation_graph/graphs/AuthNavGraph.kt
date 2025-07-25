package com.example.todo.navigation_graph.graphs

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.auth.Login
import com.example.todo.feature_todo.presentation.auth.Signup
import com.example.todo.feature_todo.presentation.auth.viewmodel.AuthViewModel
import com.example.todo.navigation_graph.routes.GraphRoutes
import com.example.todo.navigation_graph.routes.Screen
import com.example.todo.ui.theme.LocalTheme

@Composable
fun AuthNavGraph(authViewModel: AuthViewModel) {
    val theme = LocalTheme.current
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.background(theme.colors.backgroundPrimary),
        navController = navController,
        route = GraphRoutes.AUTH,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Signup.route) {
            Signup(
                authViewModel,
                onBackButtonClick = {
                    navController.navigateUp()
                },
                onLoginClick = {
                    navController.navigate(Screen.Login.route)
                })
        }
        composable(route = Screen.Login.route) {
            Login(
                authViewModel,
                onRegisterClick = {
                    navController.navigate(Screen.Signup.route)
                })
        }
    }
}