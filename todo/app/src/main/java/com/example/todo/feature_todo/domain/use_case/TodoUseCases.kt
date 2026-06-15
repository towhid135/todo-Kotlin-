package com.example.todo.feature_todo.domain.use_case

import javax.inject.Inject

data class TodoUseCases @Inject constructor(
     val getAllTodosUseCase: GetAllTodosUseCase,
     val createTodoUseCase: CreateTodoUseCase,
     val updateTodoUseCase: UpdateTodoUseCase,
     val getTodoByIdUseCase: GetTodoByIdUseCase,
     val getUserUseCase: GetUserUseCase,
     val updateUserUseCase: UpdateUserUseCase,
     val deleteTodoUseCase: DeleteTodoUseCase,
     val logoutUseCase: LogoutUseCase
)