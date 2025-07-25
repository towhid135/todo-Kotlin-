package com.example.todo.feature_todo.presentation.home.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoResult
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.domain.use_case.UserResult
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.feature_todo.presentation.home.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    sealed class UiEvent {
        data object ShowSnackbar:UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow:SharedFlow<UiEvent> = _uiEventFlow

    private var getTodoItemJob: Job? = null

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(error = e.message, isLoading = false)
    }

    init {
        viewModelScope.launch(dispatcher + errorHandler) {
            val userEmail = "towhidulislam252"
            when (val userResponse: UserResult = todoUseCases.getUserByMail(userEmail)) {
                is UserResult.Success -> {
                    _state.value = _state.value.copy(
                        user = userResponse.user
                    )
                }

                is UserResult.Error -> {
                    _state.value = _state.value.copy(
                        error = userResponse.message
                    )
                }
            }

        }
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.ToggleCompleted -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                    todoUseCases.toggleCompletedTodoItem(event.user, event.todo)
                    getTodoItems(_state.value.user.id)
                    _state.value = _state.value.copy(
                        isLoading = false
                    )
                }
            }

            is HomeScreenEvent.TodoCardPress -> {
                //TODO: NEED TO IMPLEMENT
            }

            is HomeScreenEvent.Sort -> {
                val isStateOrderAlreadyMatchesEventOrder =
                    event.todoItemOrder::class == _state.value.todoItemOrder::class &&
                            event.todoItemOrder.sortingDirection == _state.value.todoItemOrder.sortingDirection
                if (isStateOrderAlreadyMatchesEventOrder) return;

                _state.value = _state.value.copy(
                    todoItemOrder = event.todoItemOrder
                )
                getTodoItems(_state.value.user.id)
            }

            is HomeScreenEvent.OnChangeTitle -> {
                _state.value = _state.value.copy(
                    newTodo = _state.value.newTodo.copy(title = event.title)
                )
            }

            is HomeScreenEvent.OnChangeDescription -> {
                _state.value = _state.value.copy(
                    newTodo = _state.value.newTodo.copy(description = event.description)
                )
            }

            is HomeScreenEvent.OnSelectCategory -> {
                _state.value = _state.value.copy(
                    newTodo = _state.value.newTodo.copy(category = event.category.copy(isSelected = !event.category.isSelected))
                )
            }

            is HomeScreenEvent.OnSelectPriority -> {
                _state.value = _state.value.copy(
                    newTodo = _state.value.newTodo.copy(priority = event.priority)
                )
            }

            is HomeScreenEvent.OnSelectDueDate -> {
                _state.value = _state.value.copy(
                    newTodo = _state.value.newTodo.copy(dueDate = event.dueDate)
                )
            }

            is HomeScreenEvent.OnPressAddTodo -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    _state.value = _state.value.copy(isLoading = true)
                    try {
                        todoUseCases.addTodoItem(event.user, event.newTodo)
                        getTodoItems(_state.value.user.id)
                        _state.value = _state.value.copy(
                            newTodo = HomeScreenState().newTodo,
                            isLoading = false
                        )
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            error = e.message,
                            isLoading = false
                        )
                        _uiEventFlow.emit(UiEvent.ShowSnackbar)
                    }
                }
            }

        }
    }

    fun getTodoItems(userId: String) {
        getTodoItemJob?.cancel()
        getTodoItemJob = viewModelScope.launch(dispatcher + errorHandler) {
            _state.value = _state.value.copy(isLoading = true)
            val result =
                todoUseCases.getTodoItems(userId, todoItemOrder = _state.value.todoItemOrder)

            when (result) {
                is TodoResult.Success -> {
                    _state.value = _state.value.copy(
                        todoItems = result.todoItems,
                        todoItemOrder = _state.value.todoItemOrder,
                        isLoading = false
                    )
                }

                is TodoResult.Error -> {
                    _state.value = _state.value.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }

        }
    }

}