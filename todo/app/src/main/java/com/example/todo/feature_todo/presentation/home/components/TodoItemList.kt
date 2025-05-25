package com.example.todo.feature_todo.presentation.home.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemList(
    modifier: Modifier = Modifier,
    todoItems:List<TodoItem>,
    user: User,
    isLoading:Boolean,
    error:String? = null,
    onPullToRefresh:() -> Unit,
    onEvent:(HomeScreenEvent) -> Unit
    ){
    val theme = LocalTheme.current
    val pullToRefreshState = rememberPullToRefreshState()

    fun onRefresh(){
        onPullToRefresh()
    }

    PullToRefreshBox(
        modifier = modifier.fillMaxSize()
            .background(theme.colors.backgroundPrimary),
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
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .padding(top = 10.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(todoItems.size, key = {it}) { todoItemIndex ->
                    val todoItem = todoItems[todoItemIndex]
                    TodoItemCard(
                        todo = todoItem,
                        onCompleteClick = { onEvent(HomeScreenEvent.ToggleCompleted(user,todoItem)) },
                        onCardClick = {

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