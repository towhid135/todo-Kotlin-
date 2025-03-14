package com.example.todo.feature_todo.presentation.todo_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.use_case.TodoUseCaseResult
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoUseCases:TodoUseCases,
    @IoDispatcher private val dispatcher:CoroutineDispatcher
):ViewModel() {
    private val _state = mutableStateOf(TodoListState())
    val state:State<TodoListState> = _state

    private var undoTodoItem:TodoItem? = null
    private var getTodoItemJob:Job? = null

    private val errorHandler = CoroutineExceptionHandler{_,e ->
        e.printStackTrace()
        _state.value = _state.value.copy(error = e.message, isLoading = false)
    }

    fun onEvent(event: TodoListEvent){
        when(event){
            is TodoListEvent.Delete -> {
                viewModelScope.launch(dispatcher+errorHandler) {
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = true
                    )
                    todoUseCases.deleteTodoItem(event.todo)
                    getTodoItems()
                    undoTodoItem = event.todo
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = false
                    )
                }
            }

            is TodoListEvent.Sort -> {
                val isStateOrderAlreadyMatchesEventOrder = event.todoItemOrder::class == _state.value.todoItemOrder::class &&
                        event.todoItemOrder.sortingDirection == _state.value.todoItemOrder.sortingDirection &&
                        event.todoItemOrder.showArchived == _state.value.todoItemOrder.showArchived
                if(isStateOrderAlreadyMatchesEventOrder) return;

                _state.value = _state.value.copy(
                    todoItemOrder = event.todoItemOrder
                )
                getTodoItems()
            }

            is TodoListEvent.ToggleArchived -> {
                viewModelScope.launch (dispatcher+errorHandler) {
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = true
                    )
                    todoUseCases.toggleArchiveTodoItem(event.todo)
                    getTodoItems()
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = false
                    )
                }
            }

            is TodoListEvent.ToggleCompleted -> {
                viewModelScope.launch(dispatcher+errorHandler){
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = true
                    )
                    todoUseCases.toggleCompletedTodoItem(event.todo)
                    getTodoItems()
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = false
                    )
                }
            }

            is TodoListEvent.UndoDelete -> {
                viewModelScope.launch(dispatcher+errorHandler){
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = true
                    )
                    todoUseCases.addTodoItem(undoTodoItem ?: return@launch)
                    undoTodoItem = null
                    getTodoItems()
                    _state.value = _state.value.copy(
                        isToggleArchiveLoading = false
                    )
                }
            }
        }
    }

    fun getTodoItems(){
        getTodoItemJob?.cancel()
        getTodoItemJob = viewModelScope.launch(dispatcher+errorHandler){
            _state.value = _state.value.copy(isLoading = true)
            val result = todoUseCases.getTodoItems(todoItemOrder = _state.value.todoItemOrder)
            when(result){
                is TodoUseCaseResult.Success -> {
                    _state.value = _state.value.copy(
                        todoItems = result.todoItems,
                        todoItemOrder = _state.value.todoItemOrder,
                        isLoading = false
                    )
                }
                is TodoUseCaseResult.Error -> {
                    _state.value = _state.value.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }

        }
    }

}