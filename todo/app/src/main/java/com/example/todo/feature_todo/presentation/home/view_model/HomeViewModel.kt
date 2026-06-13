package com.example.todo.feature_todo.presentation.home.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.collectUseCaseFlow
import com.example.todo.core.util.sharedFlowWithReplay1
import com.example.todo.feature_todo.data.datastore.TodoPreferenceStore
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.home.HomeScreenEvent
import com.example.todo.feature_todo.presentation.home.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val todoUseCases: TodoUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    sealed class UiEvent {
        data object ShowSnackbar : UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow: SharedFlow<UiEvent> = _uiEventFlow
    val _triggerGetAllTodos = sharedFlowWithReplay1<Long>()
    val _triggerCreateTodo = sharedFlowWithReplay1<TodoItem>()

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.update { it.copy(error = e.message, isGetAllTodosLoading = false) }
    }

    init {
        getAllTodos()
        collectUseCaseFlow(
            trigger = _triggerGetAllTodos,
            useCase = {userId -> todoUseCases.getAllTodosUseCase(userId)},
            onLoading = ::onGetAllTodosLoading,
            onSuccess = ::onSuccessGetAllTodos,
            onError = ::onGetAllTodosError
        )

        collectUseCaseFlow(
            trigger = _triggerCreateTodo,
            useCase = { todo -> todoUseCases.createTodoUseCase(todo) },
            onLoading = ::onCreateTodoLoading,
            onSuccess = ::onSuccessCreateTodo,
            onError = ::onCreateTodoError
        )

        viewModelScope.launch(dispatcher + errorHandler) {
            TodoPreferenceStore.getUserIdFlow(context).collect { userId ->
                userId?.takeIf { it.toString().isNotEmpty() }?.let {
                    _state.update { current ->
                        current.copy(
                            user = User(
                                id = it,
                                name = "",
                                email = ""
                            )
                        )
                    }

                    // trigger getting todos as soon as we have a userId
                    _triggerGetAllTodos.tryEmit(it)
                }
            }
        }

        viewModelScope.launch(dispatcher + errorHandler) {
            TodoPreferenceStore.getUserProfileImage(context).collect { profileImagUrl ->
                profileImagUrl?.takeIf { it.isNotEmpty() }?.let {
                    _state.update { current -> current.copy(user = current.user.copy(profileImageUrl = it)) }
                }
            }
        }


    }

    fun onEvent(event: HomeScreenEvent) {
        viewModelScope.launch {
            when (event) {
                HomeScreenEvent.GetAllTodos -> {
                    getAllTodos()
                }
                is HomeScreenEvent.ToggleCompleted -> {

                }

                is HomeScreenEvent.TodoCardPress -> {
                    //TODO: NEED TO IMPLEMENT
                }

                is HomeScreenEvent.Sort -> {

                }

                is HomeScreenEvent.OnChangeTitle -> {
                    _state.update { current ->
                        current.copy(newTodo = current.newTodo.copy(title = event.title))
                    }
                }

                is HomeScreenEvent.OnChangeDescription -> {
                    _state.update { current ->
                        current.copy(newTodo = current.newTodo.copy(description = event.description))
                    }
                }

                is HomeScreenEvent.OnSelectCategory -> {
                    // update the newTodo's category so dialogs and UI reflect selection
                    _state.update { current -> current.copy(newTodo = current.newTodo.copy(category = event.category)) }
                }

                is HomeScreenEvent.OnSelectPriority -> {
                    // map Priority enum to integer expected by the API (1=LOW,2=MEDIUM,3=HIGH)
                    val priorityInt = when (event.priority) {
                        com.example.todo.core.util.Priority.LOW -> 1
                        com.example.todo.core.util.Priority.MEDIUM -> 2
                        com.example.todo.core.util.Priority.HIGH -> 3
                    }
                    _state.update { current -> current.copy(newTodo = current.newTodo.copy(priority = priorityInt)) }
                }

                is HomeScreenEvent.OnSelectDueDate -> {
                    // event.dueDate is epoch millis from the date picker; convert to ZonedDateTime
                    val zdt = try {
                        Instant.ofEpochMilli(event.dueDate).atZone(ZoneId.systemDefault())
                    } catch (_: Exception) {
                        _state.value.newTodo.dueDate
                    }
                    _state.update { current -> current.copy(newTodo = current.newTodo.copy(dueDate = zdt)) }
                }

                is HomeScreenEvent.OnPressAddTodo -> {
                    val userId = _state.value.user.id
                    if (userId != 0L) {
                        _triggerCreateTodo.tryEmit(event.newTodo.copy(userId = userId ?: 0L))
                    }
                }

            }
        }
    }

    fun onGetAllTodosLoading(){
        _state.update { it.copy(isGetAllTodosLoading = true) }
    }
    fun onSuccessGetAllTodos(todoList: List<TodoItem>){
        _state.update { it.copy(todoItems = todoList, isGetAllTodosLoading = false) }
        Log.d("HomeViewModel", "todoList: $todoList")
    }

    fun onGetAllTodosError(message: String){
        _state.update { it.copy(isGetAllTodosLoading = false, error = message) }
        Log.e("HomeViewModel", "getAllTodos error: $message")
    }

    fun onCreateTodoLoading() {
        _state.update { it.copy(isCreateTodoLoading = true) }
    }

    fun onSuccessCreateTodo(createdTodo: TodoItem) {
        _state.update { it.copy(isCreateTodoLoading = false) }
        getAllTodos()
    }

    fun onCreateTodoError(message: String) {
        _state.update { it.copy(isCreateTodoLoading = false, error = message) }
    }

    fun getAllTodos() {
        viewModelScope.launch {
            val userId = TodoPreferenceStore.getUserId(context)
            userId?.let { id -> _triggerGetAllTodos.tryEmit(id) }
        }
    }

}