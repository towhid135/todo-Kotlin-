package com.example.todo.feature_todo.presentation.todo_list

import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder

data class TodoListState(
    val todoItems:List<TodoItem> = emptyList(),
    val todoItemOrder:TodoItemOrder = TodoItemOrder.Time(SortingDirection.Down,true),
    val isLoading:Boolean = true,
    val isDeleteLoading: Boolean = false,
    val isToggleArchiveLoading: Boolean = false,
    val isToggleCompleteLoading: Boolean = false,
    val error:String? = null
)