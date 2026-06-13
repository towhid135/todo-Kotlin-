package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateTodoUseCase @Inject constructor(private val repo: HomeRepo) {
    operator fun invoke(todo: TodoItem): Flow<ApiResult<TodoItem>> {
        return repo.updateTodo(todo)
    }
}
