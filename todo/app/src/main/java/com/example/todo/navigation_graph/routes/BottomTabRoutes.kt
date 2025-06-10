package com.example.todo.navigation_graph.routes

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Calendar
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.User

data class BottomTabRoute(val title:String, val route:String, val icon: ImageVector)

val bottomTabRoutes = listOf(
    BottomTabRoute("Home", Screen.Home.route,Todoz.Home),
    BottomTabRoute("Calender", Screen.Calendar.route,Todoz.Calendar),
    BottomTabRoute("Profile", Screen.Profile.route,Todoz.User)
    )

