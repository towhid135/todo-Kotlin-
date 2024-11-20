package com.example.todo.feature_todo.presentation.todo_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoUseCases:TodoUseCases,
    @IoDispatcher private val dispatcher:CoroutineDispatcher
){
    private val _state = mutableStateOf(TodoListState())
    val state:State<TodoListState> = _state

    private var undoTodoItem:TodoItem? = null
    private var getTodoItemJob:Job? = null

}