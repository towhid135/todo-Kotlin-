package com.example.todo.feature_todo.presentation.home

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.TodoItemOrder

sealed class HomeScreenEvent {
    data class ToggleCompleted(val user:User,val todo:TodoItem):HomeScreenEvent()
    data class TodoCardPress(val todo: TodoItem): HomeScreenEvent()
    data class Sort(val todoItemOrder: TodoItemOrder):HomeScreenEvent()
    data class OnChangeTitle(val title:String):HomeScreenEvent()
    data class OnChangeDescription(val description:String):HomeScreenEvent()
    data class OnSelectCategory(val category:Category): HomeScreenEvent()
    data class OnSelectPriority(val priority: Priority): HomeScreenEvent()
    data class OnSelectDueDate(val dueDate: Long): HomeScreenEvent()
    data class OnPressAddTodo(val user: User,val newTodo:TodoItem): HomeScreenEvent()
}