package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem

interface TodoListRepo {
    suspend fun getAllTodos():List<TodoItem>
    suspend fun getAllTodosFromLocalCache():List<TodoItem>
    suspend fun getAllTodosFromRemote()
    suspend fun getSingleTodoItemById(id: Int): TodoItem?
    suspend fun addTodoItem(todo: TodoItem)
    suspend fun updateTodoItem(todo: TodoItem)
    suspend fun deleteTodoItem(todo: TodoItem)
    suspend fun addUser(user:User)
    suspend fun getUserById(user: User):Map<String,User>
}