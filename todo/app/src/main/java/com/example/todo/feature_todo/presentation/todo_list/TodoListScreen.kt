package com.example.todo.feature_todo.presentation.todo_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.R
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import com.example.todo.feature_todo.presentation.todo_list.components.DrawerOptions

@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    val backgroundImage = if(isPortrait){
        R.drawable.background_portrait
    }else{
        R.drawable.background_landscape
    }

    LaunchedEffect(key1 = true) {
        viewModel.getTodoItems()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(state.todoItemOrder, onOrderChange = {order ->
            viewModel.onEvent(TodoListEvent.Sort(order))
        }) }
    ) {
        //
    }
}

@Composable
fun DrawerContent(todoItemOrder:TodoItemOrder,onOrderChange:(TodoItemOrder) -> Unit){
    Box(modifier = Modifier.fillMaxWidth(0.65f)){
        ModalDrawerSheet {
            Text(
                text = TodoListStrings.SORT_BY,
                modifier = Modifier.padding(16.dp),
                fontSize = 34.sp,
                lineHeight = 18.sp
            )
            HorizontalDivider()
            DrawerOptions(
                todoItemOrder = todoItemOrder,
                onOrderChange = onOrderChange
            )
        }
    }
}