package com.example.todo.navigation_graph.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.feature_todo.presentation.home.components.HomeScaffold
import com.example.todo.navigation_graph.routes.GraphRoutes

@Composable
fun RootNavGraph(){
    val navController = rememberNavController()
    NavHost(navController=navController, route = GraphRoutes.ROOT ,startDestination = GraphRoutes.HOME) {
        composable(route=GraphRoutes.HOME){
            HomeScaffold()
        }
    }
}