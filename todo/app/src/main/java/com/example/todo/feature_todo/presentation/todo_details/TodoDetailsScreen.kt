package com.example.todo.feature_todo.presentation.todo_details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.TodoDetailsStrings
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.todo_details.components.TodoDetailsItem
import com.example.todo.feature_todo.presentation.todo_details.view_model.TodoDetailsViewModel
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Clock
import com.example.todo.ui.icons.todoz.Edit
import com.example.todo.ui.icons.todoz.Flag
import com.example.todo.ui.icons.todoz.Tag
import com.example.todo.ui.icons.todoz.Trash
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest
import timeStampToDate

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun TodoDetailsScreen(
    navigateUp: () -> Unit,
    todoDetailsViewModel: TodoDetailsViewModel = hiltViewModel()
) {
    val theme = LocalTheme.current
    val state = todoDetailsViewModel.state
    val todo = state.value.todo
    val dueDate = timeStampToDate(todo!!.dueDate)
    val dueDateString = "${dueDate.dayNumber} ${dueDate.monthName}, ${dueDate.year}"

    val uiEventFlow = todoDetailsViewModel.uiEventFlow

    LaunchedEffect(key1 = true) {
        uiEventFlow.collectLatest { event ->
            when (event) {
                TodoDetailsViewModel.UiEvent.BackButton -> navigateUp()
            }
        }
    }

    Scaffold(
        topBar = {
            TodoListScreenTopAppBar(
                title = TodoListStrings.DETAILS,
                leftIcon = Icons.AutoMirrored.Filled.ArrowBackIos,
                onLeftIconClick = { todoDetailsViewModel.onUiEvent(TodoDetailsViewModel.UiEvent.BackButton) })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = theme.colors.backgroundPrimary)
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.Top
            ) {
                RadioButton(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(top = 6.dp),
                    selected = todo.completed,
                    onClick = {},
                    colors = RadioButtonDefaults.colors(
                        selectedColor = theme.colors.iconPrimary,
                        unselectedColor = theme.colors.iconPrimary
                    )
                )
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = todo.title,
                        fontSize = 16.sp,
                        color = theme.colors.textPrimary,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = todo.description,
                        fontSize = 14.sp,
                        color = theme.colors.textPrimary,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal
                    )
                }
                Icon(
                    modifier = Modifier

                        .size(25.dp),
                    imageVector = Todoz.Edit,
                    contentDescription = null,
                    tint = theme.colors.iconPrimary,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            TodoDetailsItem(Todoz.Clock, TodoDetailsStrings.DUE_DATE, dueDateString)
            Spacer(modifier = Modifier.height(40.dp))
            TodoDetailsItem(Todoz.Tag, TodoDetailsStrings.TASK_CATEGORY, todo.category.title)
            Spacer(modifier = Modifier.height(40.dp))
            TodoDetailsItem(
                Todoz.Flag,
                TodoDetailsStrings.TASK_PRIORITY,
                todo.priority.toString().lowercase().replaceFirstChar { it.uppercase() })
            Spacer(modifier = Modifier.height(80.dp))
            Row(
                modifier = Modifier.clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(25.dp),
                    imageVector = Todoz.Trash,
                    contentDescription = null,
                    tint = theme.colors.error,
                )
                Text(
                    text = TodoDetailsStrings.DELETE_TASK,
                    fontSize = 14.sp,
                    color = theme.colors.error,
                    fontFamily = FontFamily.SansSerif,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton(
                    type = ButtonType.FILLED,
                    size = ButtonSize.LARGE,
                    title = ButtonTitle.EDIT_TASK,
                    onPress = { }
                )
            }
        }
    }

}