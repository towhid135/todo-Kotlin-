package com.example.todo.navigation_graph.graphs

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo.feature_todo.presentation.calendar.CalendarScreen
import com.example.todo.feature_todo.presentation.home.HomeScreen
import com.example.todo.feature_todo.presentation.home.view_model.HomeViewModel
import com.example.todo.feature_todo.presentation.profile.ProfileScreen
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsScreen
import com.example.todo.feature_todo.presentation.todo_details.view_model.TodoDetailsViewModel
import com.example.todo.navigation_graph.routes.GraphRoutes
import com.example.todo.navigation_graph.routes.Screen
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNavGraph(navController: NavHostController, homeViewModel: HomeViewModel, todoDetailsViewModel: TodoDetailsViewModel) {
    val theme = LocalTheme.current
    NavHost(
        modifier = Modifier.background(theme.colors.backgroundPrimary),
        navController = navController,
        route = GraphRoutes.HOME,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onCardClick = {navController.navigate(Screen.TodoDetails.route)},
                viewModel = homeViewModel
            )
        }
        composable(route = Screen.Calendar.route) {
            CalendarScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Screen.TodoDetails.route) {
            TodoDetailsScreen(navigateUp = {navController.navigateUp()},todoDetailsViewModel)
        }
    }
}