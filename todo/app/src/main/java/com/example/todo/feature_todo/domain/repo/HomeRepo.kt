package com.example.todo.feature_todo.domain.repo

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface HomeRepo {
    fun getAllTodos(userId: Long): Flow<ApiResult<List<TodoItem>>>
    fun createTodo(todo: TodoItem): Flow<ApiResult<TodoItem>>
    fun updateTodo(todo: TodoItem): Flow<ApiResult<TodoItem>>
    suspend fun getAllTodosFromLocalCache():List<TodoItem>
    suspend fun getAllTodosFromRemote(userId: String)
    fun getTodoById(id: Long): Flow<ApiResult<TodoItem>>
    suspend fun addTodoItem(user: User,todo: TodoItem)
    suspend fun updateTodoItem(user: User,todo: TodoItem)
    suspend fun deleteTodoItem(user: User,todo: TodoItem)
    suspend fun addUser(user: Map<String,User>)
    suspend fun getUserByMail(email: String):User

    suspend fun clearAllTodoItems()

    suspend fun updateUser(email: String, user: User)
    suspend fun getTodosByDateRange(
        userId: Long,
        startAt: Long,
        endAt: Long
    ): List<TodoItem>
}