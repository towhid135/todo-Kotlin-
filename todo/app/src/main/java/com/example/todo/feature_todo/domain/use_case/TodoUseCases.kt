package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.TodoConstants
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import com.example.todo.feature_todo.domain.util.InvalidTodoItemException
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import javax.inject.Inject

class TodoUseCases @Inject constructor(
    private val repo: HomeRepo
) {
    suspend fun addTodoItem(user: User, todo: TodoItem) {
        if (todo.title.isBlank() || todo.description.isBlank()) {
            throw InvalidTodoItemException(TodoConstants.EMPTY_TITLE_OR_DESCRIPTION)
        }
        repo.addTodoItem(user, todo)
    }

    suspend fun updateTodoItem(user: User, todo: TodoItem) {
        if (todo.title.isBlank() || todo.description.isBlank()) {
            throw InvalidTodoItemException(TodoConstants.EMPTY_TITLE_OR_DESCRIPTION)
        }
        repo.updateTodoItem(user, todo)
    }

    suspend fun deleteTodoItem(user: User,todo: TodoItem) {
        repo.deleteTodoItem(user,todo)
    }

    suspend fun toggleCompletedTodoItem(user: User, todo: TodoItem) {
        repo.updateTodoItem(user, todo.copy(completed = !todo.completed))
    }

    suspend fun getTodoItemById(id: String): TodoItem? {
        return repo.getSingleTodoItemById(id)
    }

    suspend fun getTodoItems(
        userId: String,
        todoItemOrder: TodoItemOrder = TodoItemOrder.Time(SortingDirection.DESC)
    ): TodoResult {
//        var todos = repo.getAllTodosFromLocalCache()
        val todos = repo.getAllTodos(userId)
//        if(todos.isEmpty()){
//            todos = repo.getAllTodos()
//        }

        return when (todoItemOrder.sortingDirection) {
            is SortingDirection.DESC -> {
                when (todoItemOrder) {
                    is TodoItemOrder.Title -> TodoResult.Success(todos.sortedByDescending { it.title.lowercase() })
                    is TodoItemOrder.Time -> TodoResult.Success(todos.sortedByDescending { it.createdAt })
                    is TodoItemOrder.Completed -> TodoResult.Success(todos.sortedByDescending { it.completed })
                }
            }

            is SortingDirection.ASC -> {
                when (todoItemOrder) {
                    is TodoItemOrder.Title -> TodoResult.Success(todos.sortedBy { it.title.lowercase() })
                    is TodoItemOrder.Time -> TodoResult.Success(todos.sortedBy { it.createdAt })
                    is TodoItemOrder.Completed -> TodoResult.Success(todos.sortedBy { it.completed })
                }
            }
        }
    }

    suspend fun addUser(user: Map<String, User>) {
        repo.addUser(user)
    }

    suspend fun getUserByMail(email: String): UserResult {
        try {
            val userResponse = repo.getUserByMail(email)
            return UserResult.Success(userResponse)
        } catch (error: Error) {
            return UserResult.Error(error.message ?: "getUserByMail error")
        }
    }
}

sealed class UserResult {
    data class Success(val user: User) : UserResult()
    data class Error(val message: String) : UserResult()
}

sealed class TodoResult {
    data class Success(val todoItems: List<TodoItem>) : TodoResult()
    data class Error(val message: String) : TodoResult()
}