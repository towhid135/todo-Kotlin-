package com.example.todo.feature_todo.presentation.todo_details.view_model

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsEvent
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class TodoDetailsViewModel @Inject constructor(
    private val repo: HomeRepo,
    private val todoUseCases: TodoUseCases,
    savedStateHandle: SavedStateHandle,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = MutableStateFlow(TodoDetailsState())
    val state: StateFlow<TodoDetailsState> = _state.asStateFlow()

    sealed class UiEvent {
        data object BackButton : UiEvent()
        data class DeleteButton(val showDialog: Boolean) : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow.asSharedFlow()

    val _triggerUpdateTodo = sharedFlowWithReplay1<TodoItem>()
    val _triggerGetTodoById = sharedFlowWithReplay1<Long>()
    val _triggerDeleteTodo = sharedFlowWithReplay1<Long>()

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.update { it.copy(error = e.message, isGetTodoByIdLoading = false, isUpdateTodoLoading = false) }
    }

    init {
        savedStateHandle.get<String>("todoId")?.let { todoId ->
            todoId.toLongOrNull()?.let { id ->
                _triggerGetTodoById.tryEmit(id)
            }
        }

        viewModelScope.launch(dispatcher + errorHandler) {
            TodoPreferenceStore.getUserIdFlow(context).collect { userId ->
                userId?.takeIf { it.toString().isNotEmpty() }?.let { uid ->
                    _state.update { current ->
                        current.copy(
                            user = User(
                                id = uid,
                                name = "",
                                email = ""
                            )
                        )
                    }
                }
            }
        }

        viewModelScope.launch(dispatcher + errorHandler) {
            TodoPreferenceStore.getAuthToken(context).collect { token ->
                _state.update { it.copy(authToken = token) }
            }
        }

        collectUseCaseFlow(
            trigger = _triggerUpdateTodo,
            useCase = { todo -> todoUseCases.updateTodoUseCase(todo) },
            onLoading = ::onUpdateTodoLoading,
            onSuccess = ::onSuccessUpdateTodo,
            onError = ::onUpdateTodoError
        )

        collectUseCaseFlow(
            trigger = _triggerGetTodoById,
            useCase = { id -> todoUseCases.getTodoByIdUseCase(id) },
            onLoading = ::onGetTodoByIdLoading,
            onSuccess = ::onSuccessGetTodoById,
            onError = ::onGetTodoByIdError
        )

        collectUseCaseFlow(
            trigger = _triggerDeleteTodo,
            useCase = { id -> todoUseCases.deleteTodoUseCase(id) },
            onLoading = ::onDeleteTodoLoading,
            onSuccess = ::onSuccessDeleteTodo,
            onError = ::onDeleteTodoError
        )
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
                handleDeleteTodo(event.todo.id)
            }

            is TodoDetailsEvent.OnChangeTitle -> {
                _state.update { current ->
                    current.copy(todo = current.todo?.copy(title = event.title))
                }
            }

            is TodoDetailsEvent.OnChangeDescription -> {
                _state.update { current ->
                    current.copy(todo = current.todo?.copy(description = event.description))
                }
            }

            is TodoDetailsEvent.OnSelectCategory -> {
                _state.update { current ->
                    current.copy(
                        todo = current.todo?.copy(
                            category = event.category.copy(isSelected = !event.category.isSelected)
                        )
                    )
                }
            }

            is TodoDetailsEvent.OnSelectPriority -> {
                // map Priority enum to Int values used by the domain model
                val priorityInt = when (event.priority) {
                    com.example.todo.core.util.Priority.LOW -> 1
                    com.example.todo.core.util.Priority.MEDIUM -> 2
                    com.example.todo.core.util.Priority.HIGH -> 3
                }

                _state.update { current ->
                    current.copy(todo = current.todo?.copy(priority = priorityInt))
                }
            }

            is TodoDetailsEvent.OnSelectDueDate -> {
                // convert epoch millis (Long) to ZonedDateTime used by domain model
                val zonedDueDate = Instant.ofEpochMilli(event.dueDate).atZone(ZoneId.systemDefault())
                _state.update { current ->
                    current.copy(todo = current.todo?.copy(dueDate = zonedDueDate))
                }
            }

            is TodoDetailsEvent.OnPressAddTodo -> {
                handlePressAddTodo(event.updateTodo)
            }
        }
    }

    private fun handlePressAddTodo(todo: TodoItem) {
        _triggerUpdateTodo.tryEmit(todo)
    }

    fun onUpdateTodoLoading() {
        _state.update { it.copy(isUpdateTodoLoading = true) }
    }

    fun onSuccessUpdateTodo(updatedTodo: TodoItem) {
        _state.update { it.copy(isUpdateTodoLoading = false, todo = updatedTodo) }
        viewModelScope.launch {
            _uiEventFlow.emit(UiEvent.BackButton)
        }
    }

    fun onUpdateTodoError(message: String) {
        _state.update { it.copy(isUpdateTodoLoading = false, error = message) }
    }

    fun onGetTodoByIdLoading() {
        _state.update { it.copy(isGetTodoByIdLoading = true) }
    }

    fun onSuccessGetTodoById(todoItem: TodoItem) {
        _state.update { it.copy(isGetTodoByIdLoading = false, todo = todoItem) }
    }

    fun onGetTodoByIdError(message: String) {
        _state.update { it.copy(isGetTodoByIdLoading = false, error = message) }
    }

    private fun handleDeleteTodo(id: Long) {
        _triggerDeleteTodo.tryEmit(id)
    }

    fun onDeleteTodoLoading() {
        _state.update { it.copy(isDeleteTodoLoading = true) }
    }

    fun onSuccessDeleteTodo(unit: Unit) {
        _state.update { it.copy(isDeleteTodoLoading = false) }
        viewModelScope.launch {
            _uiEventFlow.emit(UiEvent.BackButton)
        }
    }

    fun onDeleteTodoError(message: String) {
        _state.update { it.copy(isDeleteTodoLoading = false, error = message) }
    }
}