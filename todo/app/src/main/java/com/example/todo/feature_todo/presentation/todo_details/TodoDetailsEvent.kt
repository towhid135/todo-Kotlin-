package com.example.todo.feature_todo.presentation.todo_details

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem

sealed class TodoDetailsEvent {
    data class OnDeleteTodo(val user: User, val todo: TodoItem) : TodoDetailsEvent()
    data class OnChangeTitle(val title: String) : TodoDetailsEvent()
    data class OnChangeDescription(val description: String) : TodoDetailsEvent()
    data class OnSelectCategory(val category: Category) : TodoDetailsEvent()
    data class OnSelectPriority(val priority: Priority) : TodoDetailsEvent()
    data class OnSelectDueDate(val dueDate: Long) : TodoDetailsEvent()
    data class OnPressAddTodo(val user: User, val updateTodo: TodoItem) : TodoDetailsEvent()

}