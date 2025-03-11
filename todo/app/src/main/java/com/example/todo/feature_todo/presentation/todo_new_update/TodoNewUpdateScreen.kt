package com.example.todo.feature_todo.presentation.todo_new_update

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo.R
import com.example.todo.core.presentation.components.ArchiveButton
import com.example.todo.core.presentation.components.CompleteButton
import com.example.todo.core.presentation.components.DeleteButton
import com.example.todo.core.presentation.components.getTodoColors
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.NewUpdateStrings
import com.example.todo.core.util.TodoConstants
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.presentation.todo_new_update.components.TextInput
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodoNewUpdateScreen(
    navController: NavController, viewModel: TodoNewUpdateViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val state = viewModel.state
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val todoColors = getTodoColors(todo = state.value.todo)

    val configuration = LocalConfiguration.current
    val isPortrait =
        configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    val horizontalPadding = 16.dp
    val verticalPadding = if (isPortrait) 16.dp else 2.dp

    val backgroundImage = if (isPortrait) {
        R.drawable.background_portrait
    } else {
        R.drawable.background_landscape
    }

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                TodoNewUpdateViewModel.UiEvent.Back -> {
                    navController.navigateUp()
                }

                TodoNewUpdateViewModel.UiEvent.SaveTodo -> {
                    navController.navigateUp()
                }

                is TodoNewUpdateViewModel.UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Scaffold(floatingActionButton = {
        if (!isPortrait) {
            FloatingActionButton(
                onClick = { viewModel.onEvent(TodoNewUpdateEvent.SaveTodo) },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = ContentDescriptions.SAVE_TODO,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }, topBar = {
        if (isPortrait) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = TodoListStrings.TODO_LIST,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ), navigationIcon = {
                    IconButton(
                        onClick = {
                            viewModel.onEvent(TodoNewUpdateEvent.Back)
                        }, modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = ContentDescriptions.BACK,
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }, scrollBehavior = scrollBehavior
            )
        }
    }, bottomBar = {
        BottomAppBar(actions = {
            if(state.value.todo.id != 0){
                Row(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    CompleteButton(
                        onCompleteClick = {
                            viewModel.onEvent(TodoNewUpdateEvent.ToggleCompleted)
                        }, color = todoColors.checkColor, completed = state.value.todo.completed
                    )
                    ArchiveButton(
                        onArchiveClick = {
                            viewModel.onEvent(TodoNewUpdateEvent.ToggleArchived)
                        }, color = todoColors.archiveIconColor
                    )
                    DeleteButton(onDeleteClick = {
                        scope.launch {
                            val confirm = snackbarHostState.showSnackbar(
                                message = NewUpdateStrings.CONFIRM_DELETE,
                                actionLabel = NewUpdateStrings.YES
                            )
                            if (confirm == SnackbarResult.ActionPerformed) {
                                viewModel.onEvent(TodoNewUpdateEvent.DeleteTodo)
                            }
                        }
                    })
                }
            }
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(TodoNewUpdateEvent.SaveTodo) },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = ContentDescriptions.SAVE_TODO,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }, containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
        )
    },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxSize()
                .background(color = todoColors.backgroundColor)
        ) {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = ContentDescriptions.BACKGROUND_IMAGE,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopStart
            )
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(
                        enabled = true,
                        state = rememberScrollState(),
                    )
            ) {
                TextInput(
                    text = state.value.todo.title,
                    modifier = Modifier
                        .padding(horizontal = horizontalPadding),
                    textColor = todoColors.textColor,
                    placeholder = NewUpdateStrings.TITLE_PLACE_HOLDER,
                    onValueChange = { viewModel.onEvent(TodoNewUpdateEvent.OnChangeTitle(it)) },
                    onFocusChange = { viewModel.onEvent(TodoNewUpdateEvent.ChangedTitleFocus(it)) },
                    isHintVisible = state.value.isTitleHintVisible
                )
                TextInput(text = state.value.todo.description,
                    fontSize = 24.sp,
                    textColor = todoColors.textColor,
                    singleLine = false,
                    modifier = Modifier
                        .padding(horizontal = horizontalPadding)
                        .weight(1f)
                        .padding(top = verticalPadding)
                    ,
                    textFieldModifier = Modifier.fillMaxHeight(),
                    placeholder = NewUpdateStrings.DESCRIPTION_PLACE_HOLDER,
                    onValueChange = { viewModel.onEvent(TodoNewUpdateEvent.OnchangeDescription(it)) },
                    isHintVisible = state.value.isDescriptionHintVisible,
                    onFocusChange = {
                        viewModel.onEvent(
                            TodoNewUpdateEvent.ChangedDescriptionFocus(
                                it
                            )
                        )
                    })
            }
        }
    }
}