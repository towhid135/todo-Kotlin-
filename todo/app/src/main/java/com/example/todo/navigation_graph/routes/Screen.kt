package com.example.todo.navigation_graph.routes

sealed class Screen(val route: String){
    object Home: Screen("Home")
    object TodoDetails: Screen("TodoDetails")
    object Calendar: Screen("Calendar")
    object Profile: Screen("Profile")
    object Signup: Screen("Signup")
    object Login: Screen("Login")
}