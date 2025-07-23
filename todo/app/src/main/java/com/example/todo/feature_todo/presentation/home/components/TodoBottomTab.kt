package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.todo.navigation_graph.routes.Screen
import com.example.todo.navigation_graph.routes.bottomTabRoutes
import com.example.todo.ui.theme.LocalTheme

@Composable
fun TodoBottomTab(navController: NavController) {
    val theme = LocalTheme.current

    val bottomPadding = with(LocalDensity.current) {
        WindowInsets.navigationBars.getBottom(LocalDensity.current).toDp() + 20.dp
    }

    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentDestination = navBackStackEntry?.destination
    val bottomTabAllowedFor =
        listOf(Screen.Home.route, Screen.Calendar.route, Screen.Profile.route)

    if (!bottomTabAllowedFor.contains(currentDestination?.route)) {
        return
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 80.dp, end = 80.dp, top = 10.dp, bottom = bottomPadding)
            .clip(RoundedCornerShape(16.dp))
            .background(theme.colors.backgroundSecondary)
            .border(0.5.dp, theme.colors.borderTertiary, RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            bottomTabRoutes.forEach { bottomTabItem ->
                BottomTabItem(
                    icon = bottomTabItem.icon,
                    title = bottomTabItem.title,
                    selected = currentDestination?.route == bottomTabItem.route,
                    onClick = {
                        if (currentDestination?.route != bottomTabItem.route) {
                            navController.navigate(bottomTabItem.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}