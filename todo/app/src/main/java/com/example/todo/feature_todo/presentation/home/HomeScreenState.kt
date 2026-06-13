package com.example.todo.feature_todo.presentation.home

import com.example.todo.core.util.Category
import com.example.todo.core.util.CategoryColor
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Work
import java.time.ZonedDateTime

data class HomeScreenState(
    val newTodo:TodoItem = TodoItem(
        id = 0L,
        userId = 0L,
        title = "",
        description = "",
        priority = 1,
        category = Category(
            id = 2L,
            title = Todoz.Work.name,
            bgColor = CategoryColor.PERU.colorCode,
            icon = Todoz.Work.name.lowercase()
        ),
        completed = false,
        createdAt = ZonedDateTime.now(),
        dueDate = ZonedDateTime.now().plusDays(1),
    ),
    val todoItems:List<TodoItem> = emptyList(),
    val user:User = User(),
    val todoItemOrder:TodoItemOrder = TodoItemOrder.Time(SortingDirection.DESC),
    val isGetAllTodosLoading:Boolean = false,
    val isCreateTodoLoading:Boolean = false,
    val error:String? = null
)