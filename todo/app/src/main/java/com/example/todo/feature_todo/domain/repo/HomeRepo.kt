package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem

interface HomeRepo {
    suspend fun getAllTodos(userId:String):List<TodoItem>
    suspend fun getAllTodosFromLocalCache():List<TodoItem>
    suspend fun getAllTodosFromRemote(userId: String)
    suspend fun getSingleTodoItemById(id: String): TodoItem?
    suspend fun addTodoItem(user: User,todo: TodoItem)
    suspend fun updateTodoItem(user: User,todo: TodoItem)
    suspend fun deleteTodoItem(user: User,todo: TodoItem)
    suspend fun addUser(user: Map<String,User>)
    suspend fun getUserByMail(email: String):User

    suspend fun clearAllTodoItems()

    suspend fun updateUser(email: String, user: User)
    suspend fun getTodosByDateRange(
        userId: String,
        startAt: Long,
        endAt: Long
    ): List<TodoItem>
}