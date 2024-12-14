package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder

@Composable
fun DrawerOptions(
    todoItemOrder: TodoItemOrder,
    onOrderChange: (TodoItemOrder) -> Unit
){
    val isTitleSelected = todoItemOrder::class == TodoItemOrder.Title::class
    NavigationDrawerItem(
        label = {
            DrawerItem(TodoListStrings.TITLE,isTitleSelected)
        },
        selected = false,
        onClick = {onOrderChange(TodoItemOrder.Title(todoItemOrder.sortingDirection,todoItemOrder.showArchived))}
    )
    val isTimeSelected = todoItemOrder::class == TodoItemOrder.Time::class
    NavigationDrawerItem(
        label = {
            DrawerItem(TodoListStrings.TIME,isTimeSelected)
        },
        selected = false,
        onClick = {
            onOrderChange(TodoItemOrder.Time(todoItemOrder.sortingDirection,todoItemOrder.showArchived))
        }
    )
    val isCompletedSelected = todoItemOrder::class == TodoItemOrder.Completed::class
    NavigationDrawerItem(
        label = {
            DrawerItem(TodoListStrings.Completed,isCompletedSelected)
        },
        selected = false,
        onClick = {
            onOrderChange(TodoItemOrder.Completed(todoItemOrder.sortingDirection,todoItemOrder.showArchived))
        }
    )
    val isSortUpSelected = todoItemOrder.sortingDirection == SortingDirection.Up
    NavigationDrawerItem(
        label = {
            DrawerItem(TodoListStrings.SORT_UP,isSortUpSelected)
        },
        selected=false,
        onClick = {
            onOrderChange(todoItemOrder.copy(sortingDirection = SortingDirection.Up,showArchived = todoItemOrder.showArchived))
        }
    )
    val isSortDownSelected = todoItemOrder.sortingDirection == SortingDirection.Down
    NavigationDrawerItem(
        label = {
            DrawerItem(TodoListStrings.SORT_DOWN,isSortDownSelected)
        },
        selected=false,
        onClick = {
            onOrderChange(todoItemOrder.copy(sortingDirection = SortingDirection.Down,showArchived = todoItemOrder.showArchived))
        }
    )
}



