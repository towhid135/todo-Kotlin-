package com.example.todo.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.todo.core.presentation.components.BottomTabItem
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.presentation.components.DateItem
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryBoxType
import com.example.todo.core.util.CategoryColor
import com.example.todo.core.util.Priority
import com.example.todo.core.util.dismissKeyboardAndClearFocusOnTapOutside
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.todo_list.components.CategoryBox
import com.example.todo.feature_todo.presentation.todo_list.components.CustomTextInput
import com.example.todo.feature_todo.presentation.todo_list.components.PriorityBox
import com.example.todo.feature_todo.presentation.todo_list.components.TodoItemCard
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Home
import com.example.todo.ui.icons.todoz.Search
import com.example.todo.ui.icons.todoz.University
import com.example.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val mockCategory = Category(
            id = "1",
            title = "Work",
            bgColor = CategoryColor.FUCHSIA_ROSE,
            icon = Todoz.University // Replace with an appropriate ImageVector
        )
        val mockTodoItem = TodoItem(
            id = "1",
            createdAt = System.currentTimeMillis(),
            title = "Complete HomeworkComplete Homework",
            description = "Finish math and science homework",
            completed = false,
            category = Category(
                id = "1",
                title = "Work",
                bgColor = CategoryColor.FUCHSIA_ROSE,
                icon = Todoz.University
            ),
            priority = Priority.HIGH
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                val focusManager = LocalFocusManager.current
                Surface(modifier = Modifier
                    .fillMaxSize()
                 ) {

                    Column (modifier = Modifier.fillMaxSize().scrollable(rememberScrollState(), orientation = Orientation.Horizontal), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        CustomButton(type = ButtonType.FILLED, size = ButtonSize.LARGE,title = ButtonTitle.LOGIN, isEnabled = true, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.FILLED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = false, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.OUTLINED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = true, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.OUTLINED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = false, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
                            CategoryBox(
                                category = mockCategory,
                                type = CategoryBoxType.RECTANGLE,
                                onPress = { /* Handle click */ }
                            )
                            CategoryBox(
                                category = mockCategory,
                                type = CategoryBoxType.SQUARE,
                                onPress = { /* Handle click */ }
                            )
                            TodoItemCard(
                                todo = mockTodoItem,
                                onCompleteClick = { /* Handle complete click */ },
                                onCardClick = { /* Handle card click */ }
                            )
                            BottomTabItem(
                                icon = Todoz.Home,
                                title = "Home",
                                selected = true,
                                onClick = { /* Handle click */ }
                            )
                            CustomTextInput(
                                leadingIcon = Todoz.Search,
                                text = "",
                                placeholderText = "Enter search text here",
                                labelText = "Search",
                                onValueChange = {}
                            )
                        }
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            PriorityBox(priority = Priority.LOW)
                            PriorityBox(priority = Priority.MEDIUM)
                            PriorityBox(priority = Priority.HIGH)
                        }

                        DateItem(date = System.currentTimeMillis())
                    }
                }
            }
        }
    }
}
