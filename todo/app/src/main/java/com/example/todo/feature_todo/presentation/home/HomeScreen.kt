package com.example.todo.feature_todo.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.home.components.AddTodoButton
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.DrawerContent
import com.example.todo.feature_todo.presentation.home.components.TodoItemList
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.home.view_model.HomeViewModel
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Clock
import com.example.todo.ui.icons.todoz.Filter
import com.example.todo.ui.icons.todoz.Flag
import com.example.todo.ui.icons.todoz.Send
import com.example.todo.ui.icons.todoz.Tag
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onCardClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val theme = LocalTheme.current

    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    var showBottomSheet by remember { mutableStateOf(false) }

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
                    imageUrl = "dummyUrl"
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
                    error = state.error,
                    onPullToRefresh = {
                        viewModel.getTodoItems(state.user.id)
                    },
                    onEvent = { event ->
                        viewModel.onEvent(event)
                    },
                    onCardClick = onCardClick
                )

                if (showBottomSheet) {
                    ModalBottomSheet(
                        modifier = Modifier.fillMaxHeight(),
                        onDismissRequest = {
                            showBottomSheet = false
                        },
                        sheetState = sheetState,
                        containerColor = theme.colors.backgroundSecondary,
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            CustomTextInput(
                                labelText = "Title",
                                text = state.title,
                                placeholderText = "Enter title",
                                onValueChange = { viewModel.onEvent(HomeScreenEvent.onChangeTitle(it)) }
                            )
                            CustomTextInput(
                                labelText = "Description",
                                text = state.description,
                                placeholderText = "Enter description",
                                onValueChange = {
                                    viewModel.onEvent(
                                        HomeScreenEvent.onChangeDescription(
                                            it
                                        )
                                    )
                                }
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        modifier = Modifier.clickable {  },
                                        imageVector = Todoz.Clock,
                                        contentDescription = null,
                                        tint = theme.colors.iconPrimary,
                                    )
                                    Icon(
                                        modifier = Modifier.clickable {  },
                                        imageVector = Todoz.Tag,
                                        contentDescription = null,
                                        tint = theme.colors.iconPrimary,
                                    )
                                    Icon(
                                        modifier = Modifier.clickable {  },
                                        imageVector = Todoz.Flag,
                                        contentDescription = null,
                                        tint = theme.colors.iconPrimary,
                                    )
                                }
                                Icon(
                                    modifier = Modifier.clickable {  },
                                    imageVector = Todoz.Send,
                                    contentDescription = null,
                                    tint = theme.colors.buttonPrimary,
                                )
                            }
                        }
                    }
                }

                LoadingModal(isLoading = state.isLoading)
            }
        }
    }


}




