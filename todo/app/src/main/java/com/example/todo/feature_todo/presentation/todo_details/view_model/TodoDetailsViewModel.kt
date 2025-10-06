package com.example.todo.feature_todo.presentation.todo_details.view_model

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.domain.use_case.UserResult
import com.example.todo.feature_todo.presentation.home.view_model.HomeViewModel.UiEvent
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsEvent
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailsViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    savedStateHandle: SavedStateHandle,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = mutableStateOf(TodoDetailsState())
    val state = _state

    sealed class UiEvent {
        data object BackButton : UiEvent()
        data class DeleteButton(val showDialog: Boolean) : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow.asSharedFlow()

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(error = e.message, isLoading = false)
    }

    init {
        savedStateHandle.get<String>("todoId")?.let {
            viewModelScope.launch {
                val todoItem = todoUseCases.getTodoItemById(it)
                _state.value = _state.value.copy(
                    todo = todoItem
                )
            }
        }

        viewModelScope.launch(dispatcher + errorHandler) {
            TodoPreferenceStore.getUserId(context).collect { userId ->
                userId?.takeIf { it.isNotEmpty() }?.let {
                    _state.value = _state.value.copy(
                        user = User(
                            id = it,
                            name = "",
                            email = ""
                        )
                    )
                }
            }
        }
    }

    fun onUiEvent(event: UiEvent) {
        when (event) {
            UiEvent.BackButton -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.BackButton)
                }
            }

            is UiEvent.DeleteButton -> {
                viewModelScope.launch {
                    _uiEventFlow.emit(UiEvent.DeleteButton(event.showDialog))
                }
            }
        }
    }

    fun onEvent(event: TodoDetailsEvent) {
        when (event) {
            is TodoDetailsEvent.OnDeleteTodo -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    try {
                        todoUseCases.deleteTodoItem(event.user, event.todo)
                        todoUseCases.getTodoItems(_state.value.user.id)
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            error = e.message
                        )
                    }
                }

            }

            is TodoDetailsEvent.OnChangeTitle -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo?.copy(title = event.title)
                )
            }

            is TodoDetailsEvent.OnChangeDescription -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo?.copy(description = event.description)
                )
            }

            is TodoDetailsEvent.OnSelectCategory -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo?.copy(category = event.category.copy(isSelected = !event.category.isSelected))
                )
            }

            is TodoDetailsEvent.OnSelectPriority -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo?.copy(priority = event.priority)
                )
            }

            is TodoDetailsEvent.OnSelectDueDate -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo?.copy(dueDate = event.dueDate)
                )
            }

            is TodoDetailsEvent.OnPressAddTodo -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    _state.value = _state.value.copy(isLoading = true)
                    try {
                        todoUseCases.updateTodoItem(event.user, event.updateTodo)
                        _state.value = _state.value.copy(
                            isLoading = false
                        )
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            error = e.message,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}