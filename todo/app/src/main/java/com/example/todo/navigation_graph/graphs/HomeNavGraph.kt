package com.example.todo.navigation_graph.graphs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo.feature_todo.presentation.calendar.CalendarScreen
import com.example.todo.feature_todo.presentation.home.HomeScreen
import com.example.todo.feature_todo.presentation.home.HomeViewModel
import com.example.todo.feature_todo.presentation.profile.ProfileScreen
import com.example.todo.navigation_graph.routes.GraphRoutes
import com.example.todo.navigation_graph.routes.Screen
import com.example.todo.ui.theme.LocalTheme

@Composable
fun HomeNavGraph(navController: NavHostController,innerPadding: PaddingValues) {
    val theme = LocalTheme.current
    NavHost(
        modifier = Modifier.background(theme.colors.backgroundPrimary).padding(innerPadding),
        navController = navController,
        route = GraphRoutes.HOME,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            val homeViewModel:HomeViewModel = hiltViewModel()
            HomeScreen(
                navController = navController,
                viewModel = homeViewModel
            )
        }
        composable(route = Screen.Calendar.route) {
            CalendarScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}