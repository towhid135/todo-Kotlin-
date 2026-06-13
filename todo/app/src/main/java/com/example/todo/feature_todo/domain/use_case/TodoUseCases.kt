package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.TodoConstants
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import com.example.todo.feature_todo.domain.util.InvalidTodoItemException
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import javax.inject.Inject

data class TodoUseCases @Inject constructor(
     val getAllTodosUseCase: GetAllTodosUseCase,
     val createTodoUseCase: CreateTodoUseCase,
     val updateTodoUseCase: UpdateTodoUseCase,
     val getTodoByIdUseCase: GetTodoByIdUseCase
)