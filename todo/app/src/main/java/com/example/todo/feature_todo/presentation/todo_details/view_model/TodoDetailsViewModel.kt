package com.example.todo.feature_todo.presentation.todo_details.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.domain.use_case.TodoUseCases
import com.example.todo.feature_todo.presentation.todo_details.TodoDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
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
    }

    private val _uiEventFlow = MutableSharedFlow<UiEvent>()
    val uiEventFlow:SharedFlow<UiEvent> = _uiEventFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("todoId")?.let {
            viewModelScope.launch {
                val todoItem = todoUseCases.getTodoItemById(it)
                _state.value = _state.value.copy(
                    todo = todoItem
                )
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
        }
    }
}