package com.example.todo.feature_todo.domain.repo

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    fun getAllTodos(userId: Long): Flow<ApiResult<List<TodoItem>>>
    fun createTodo(todo: TodoItem): Flow<ApiResult<TodoItem>>
    fun updateTodo(todo: TodoItem): Flow<ApiResult<TodoItem>>
    suspend fun getAllTodosFromLocalCache(): List<TodoItem>
    suspend fun getAllTodosFromRemote(userId: String)
    fun getTodoById(id: Long): Flow<ApiResult<TodoItem>>
    fun deleteTodo(id: Long): Flow<ApiResult<Unit>>

    suspend fun clearAllTodoItems()

    // User endpoints (Go backend)
    fun getUser(): Flow<ApiResult<User>>
    fun updateUser(name: String, imageUrl: String): Flow<ApiResult<User>>
    fun logout(): Flow<ApiResult<Unit>>
}