package com.example.todo.feature_todo.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.home.components.AddTodoButton
import com.example.todo.feature_todo.presentation.home.components.CreateTodoModalBottomSheet
import com.example.todo.feature_todo.presentation.home.components.DrawerContent
import com.example.todo.feature_todo.presentation.home.components.TodoItemList
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.home.view_model.HomeViewModel
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Filter
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onCardClick: (route:String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    fun toggleShowBottomSheet() {
        showBottomSheet = !showBottomSheet
    }

    LaunchedEffect(key1 = state.user.id) {
        state.user.id.takeIf { it.isNotEmpty() }?.let {
            viewModel.getTodoItems(userId = it)
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(state.todoItemOrder, onOrderChange = { order ->
                viewModel.onEvent(HomeScreenEvent.Sort(order))
            })
        }
    ) {
        Scaffold(
            floatingActionButton = {
                AddTodoButton(onAddButtonPress = {
                    showBottomSheet = true
                })
            },
            topBar = {
                TodoListScreenTopAppBar(
                    title = TodoListStrings.HOME,
                    leftIcon = Todoz.Filter,
                    onLeftIconClick = { scope.launch { drawerState.open() } },
                    imageUrl = state.user.profileImageUrl,
                    showActions = true
                )
            },

            ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TodoItemList(
                    todoItems = state.todoItems,
                    user = state.user,
                    isLoading = state.isLoading,
                    onPullToRefresh = {
                        viewModel.getTodoItems(state.user.id)
                    },
                    onEvent = { event ->
                        viewModel.onEvent(event)
                    },
                    onCardClick = onCardClick
                )

                CreateTodoModalBottomSheet(
                    newTodo = state.newTodo,
                    sheetState = sheetState,
                    showBottomSheet = showBottomSheet,
                    toggleShowBottomSheet = { toggleShowBottomSheet() },
                    scope = scope,
                    onTitleChange = { viewModel.onEvent(HomeScreenEvent.OnChangeTitle(it)) },
                    onDescriptionChange = { viewModel.onEvent(HomeScreenEvent.OnChangeDescription(it)) },
                    onCategoryChange = { viewModel.onEvent(HomeScreenEvent.OnSelectCategory(it)) },
                    onPriorityChange = { viewModel.onEvent(HomeScreenEvent.OnSelectPriority(it)) },
                    onChangeDueDate = { viewModel.onEvent(HomeScreenEvent.OnSelectDueDate(it)) },
                    onPressAddTodo = {
                        viewModel.onEvent(
                            HomeScreenEvent.OnPressAddTodo(
                                state.user,
                                it
                            )
                        )
                    }
                )

                LoadingModal(isLoading = state.isLoading)
            }
        }
    }


}




