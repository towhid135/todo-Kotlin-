package com.example.todo.feature_todo.presentation.util

sealed class Screen(val route: String){
    object Home: Screen("Home")
    object TodoNewUpdateScreen: Screen("todoNewUpdate_screen")
}