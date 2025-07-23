package com.example.todo.feature_todo.presentation.home.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemList(
    modifier: Modifier = Modifier,
    todoItems: List<TodoItem>,
    user: User,
    isLoading: Boolean,
    onPullToRefresh: () -> Unit,
    onEvent: (HomeScreenEvent) -> Unit,
    onCardClick: (route:String) -> Unit
) {
    val theme = LocalTheme.current
    val pullToRefreshState = rememberPullToRefreshState()
    val topInsets = with(LocalDensity.current){
        WindowInsets.systemBars.getTop(LocalDensity.current).toDp() + 15.dp
    }

    fun onRefresh() {
        onPullToRefresh()
    }

    PullToRefreshBox(
        modifier = modifier
            .fillMaxSize()
            .background(theme.colors.backgroundPrimary),
        state = pullToRefreshState,
        isRefreshing = isLoading,
        onRefresh = { onRefresh() },
        indicator = {
            PullToRefreshDefaults.Indicator(
                state = pullToRefreshState,
                isRefreshing = isLoading,
                modifier = Modifier.align(Alignment.TopCenter),
                color = Color.Red
            )
        }

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = topInsets)

                )
            }
            items(todoItems, key = { it.id }) { todoItem ->
                TodoItemCard(
                    todo = todoItem,
                    onCompleteClick = { onEvent(HomeScreenEvent.ToggleCompleted(user, todoItem)) },
                    onCardClick = onCardClick
                )
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp)

                )
            }
            item {
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 100.dp)

                )
            }

        }
        if (isLoading) {

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

    }
}