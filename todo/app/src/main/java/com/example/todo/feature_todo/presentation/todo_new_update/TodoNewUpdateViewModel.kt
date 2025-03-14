package com.example.todo.feature_todo.presentation.todo_new_update

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.core.util.NewUpdateStrings
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoNewUpdateViewModel @Inject constructor (
    private val todoUseCases: TodoUseCases,
    savedStateHandle: SavedStateHandle,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
    private val _state = mutableStateOf(TodoNewUpdateState())
    val state:State<TodoNewUpdateState> = _state

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        e.printStackTrace()
        _state.value = _state.value.copy(
            error = e.message,
            isLoading = false
        )
    }

    private var currentTodoId:Int? = null

    sealed class UiEvent {
        data class ShowSnackbar(val message:String):UiEvent()
        object SaveTodo:UiEvent()
        object Back:UiEvent()
    }

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<Int>("todoId")?.let { id ->
            if(id != -1){
                viewModelScope.launch(dispatcher + errorHandler) {
                    todoUseCases.getTodoItemById(id)?.also { todo ->
                        currentTodoId = todo.id
                        _state.value = _state.value.copy(
                            todo = todo,
                            isLoading = false
                        )
                    }
                }
            }else{
                _state.value = _state.value.copy(
                    isLoading = false
                )
            }
        }
    }

    fun onEvent(event: TodoNewUpdateEvent){
        when(event){
            TodoNewUpdateEvent.Back -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.Back)
                }
            }
            TodoNewUpdateEvent.DeleteTodo -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    if(currentTodoId != null){
                        todoUseCases.deleteTodoItem(_state.value.todo)
                    }
                    _eventFlow.emit(UiEvent.Back)
                }
            }
            is TodoNewUpdateEvent.OnChangeTitle -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo.copy(
                        title = event.title
                    )
                )
            }
            is TodoNewUpdateEvent.OnchangeDescription -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo.copy(
                        description = event.description
                    )
                )
            }
            is TodoNewUpdateEvent.ChangedTitleFocus -> {
                _state.value = _state.value.copy(
                    isTitleHintVisible = !event.focusState.isFocused && _state.value.todo.title.isBlank()
                )
            }
            is TodoNewUpdateEvent.ChangedDescriptionFocus -> {
                _state.value = _state.value.copy(
                    isDescriptionHintVisible = !event.focusState.isFocused && _state.value.todo.description.isBlank()
                )
            }
            TodoNewUpdateEvent.SaveTodo -> {
                viewModelScope.launch {
                    try {
                        _state.value = _state.value.copy(
                            isLoading = !_state.value.isLoading
                        )
                        if(currentTodoId != null){
                            todoUseCases.updateTodoItem(_state.value.todo)
                        }else{
                            todoUseCases.addTodoItem(_state.value.todo.copy(
                                timestamp = System.currentTimeMillis(),
                                id = 0
                            ))
                        }
                        _eventFlow.emit(UiEvent.ShowSnackbar(NewUpdateStrings.SAVE_TODO_COMPLETE))
                    }catch (e:Exception){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(e.message ?: NewUpdateStrings.SAVE_ERROR)
                        )
                    }finally {
                        _state.value = _state.value.copy(
                            isLoading = !_state.value.isLoading
                        )
                    }
                }
            }
            TodoNewUpdateEvent.ToggleArchived -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo.copy(
                        archived = !_state.value.todo.archived
                    )
                )
            }
            TodoNewUpdateEvent.ToggleCompleted -> {
                _state.value = _state.value.copy(
                    todo = _state.value.todo.copy(
                        completed = !_state.value.todo.completed
                    )
                )
            }
        }
    }

}