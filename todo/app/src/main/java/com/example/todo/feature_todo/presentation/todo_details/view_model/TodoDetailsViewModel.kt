package com.example.todo.feature_todo.presentation.todo_details.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.domain.use_case.UserResult
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsEvent
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailsViewModel @Inject constructor(
    private val todoUseCases:TodoUseCases,
    savedStateHandle: SavedStateHandle,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
):ViewModel(){

    private val _state = mutableStateOf(TodoDetailsState())
    val state = _state

    sealed class UiEvent {
        data object BackButton:UiEvent()
        data class DeleteButton(val showDialog: Boolean):UiEvent()
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow:SharedFlow<UiEvent> = _uiEventFlow.asSharedFlow()

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

        viewModelScope.launch {
            val userEmail = "towhidulislam252"
            val userResponse:UserResult = todoUseCases.getUserByMail(userEmail)

            when(userResponse){
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

    fun onUiEvent(event:UiEvent){
        when(event){
            UiEvent.BackButton -> {
                viewModelScope.launch{
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

    fun onEvent(event: TodoDetailsEvent){
        when(event){
            is TodoDetailsEvent.OnDeleteTodo -> {
                viewModelScope.launch(dispatcher + errorHandler) {
                    try {
                        todoUseCases.deleteTodoItem(event.user,event.todo)
                        todoUseCases.getTodoItems(_state.value.user.id)
                    }catch (e: Exception){
                        _state.value = _state.value.copy(
                            error = e.message
                        )
                    }
                }

            }
        }
    }
}