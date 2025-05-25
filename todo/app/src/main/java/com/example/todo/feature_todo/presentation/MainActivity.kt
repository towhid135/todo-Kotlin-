package com.example.todo.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.core.presentation.components.BottomTabItem
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.presentation.components.DateItem
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType
import com.example.todo.core.util.CategoryColor
import com.example.todo.core.util.IconAsset
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.home.HomeScreen
import com.example.todo.feature_todo.presentation.home.HomeViewModel
import com.example.todo.feature_todo.presentation.profile.components.ProfileItem
import com.example.todo.feature_todo.presentation.home.components.CategoryBox
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.PriorityBox
import com.example.todo.feature_todo.presentation.home.components.TodoItemCard
import com.example.todo.feature_todo.presentation.util.Screen
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.Search
import com.example.todo.ui.icons.todoz.Setting
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val mockCategory = Category(
            id = "1",
            title = "Work",
            bgColor = "0xFFCC4173",
            icon = "university" // Replace with an appropriate ImageVector
        )
        val mockTodoItem = TodoItem(
            id = "1",
            createdAt = System.currentTimeMillis(),
            dueDate = System.currentTimeMillis(),
            title = "Complete HomeworkComplete Homework",
            description = "Finish math and science homework",
            completed = false,
            category = Category(
                id = "1",
                title = "Work",
                bgColor = "0xFFCC4173",
                icon = "work"
            ),
            priority = Priority.HIGH
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val homeViewModel:HomeViewModel = hiltViewModel()

                    NavHost(navController=navController, startDestination = Screen.Home.route) {
                        composable(route=Screen.Home.route){
                            HomeScreen(navController,homeViewModel)
                        }
                    }

                }
            }
        }
    }
}
