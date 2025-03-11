package com.example.todo.feature_todo.presentation.todo_list.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.todo_list.TodoListEvent
import com.example.todo.feature_todo.presentation.util.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemList(
    modifier: Modifier = Modifier,
    backgroundImage: Painter,
    todoItems:List<TodoItem>,
    isLoading:Boolean,
    error:String? = null,
    onPullToRefresh:() -> Unit,
    onEvent:(TodoListEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    navController: NavController
    ){
    val pullToRefreshState = rememberPullToRefreshState()

    fun onRefresh(){
        onPullToRefresh()
    }

    PullToRefreshBox(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        state = pullToRefreshState,
        isRefreshing = isLoading,
        onRefresh = {onRefresh()},
        indicator = {
            PullToRefreshDefaults.Indicator(
                state = pullToRefreshState,
                isRefreshing = isLoading,
                modifier = Modifier.align(Alignment.TopCenter),
                color = Color.Red
            )
        }

    ){

        Image(
            painter = backgroundImage,
            contentDescription = ContentDescriptions.BACKGROUND_IMAGE,
            alignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .padding(top = 10.dp)
            ) {
                items(todoItems, key = { it.id }){ todoItem ->
                    TodoItemCard(
                        todo=todoItem,
                        modifier = Modifier.fillMaxSize()
                            .padding(4.dp),
                        onDeleteClick = {
                            onEvent(TodoListEvent.Delete(todoItem))
                            scope.launch {
                                val undo = snackbarHostState.showSnackbar(
                                    message = TodoListStrings.TODO_ITEM_DELETED,
                                    actionLabel = TodoListStrings.UNDO,
                                    withDismissAction = true
                                )
                                if(undo == SnackbarResult.ActionPerformed){
                                    onEvent(TodoListEvent.UndoDelete)
                                }
                            }
                        },
                        onArchiveClick = {onEvent(TodoListEvent.ToggleArchived(todoItem))},
                        onCompleteClick = {onEvent(TodoListEvent.ToggleCompleted(todoItem))},
                        onCardClick = {
                            navController.navigate(
                                Screen.TodoNewUpdateScreen.route + "?todoId=${todoItem.id}"
                            )
                        }
                    )
                    VerticalDivider(
                        modifier = Modifier.fillMaxSize()
                            .padding(vertical = 12.dp)

                    )
                }
            }
            if(isLoading){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.semantics {
                            this.contentDescription = ContentDescriptions.LOADING_INDICATOR
                        }
                    )
                }
            }
            if(error != null){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = error,
                        fontSize = 30.sp,
                        lineHeight = 36.sp
                    )
                }
            }
        }
    }
}