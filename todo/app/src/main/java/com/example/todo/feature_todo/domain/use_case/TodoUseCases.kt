package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.TodoConstants
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import com.example.todo.feature_todo.domain.util.InvalidTodoItemException
import com.example.todo.feature_todo.domain.util.SortingDirection
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import javax.inject.Inject

class TodoUseCases @Inject constructor(
    private val repo: TodoListRepo
) {
    suspend fun addTodoItem(todo:TodoItem){
        if(todo.title.isBlank() || todo.description.isBlank()){
            throw InvalidTodoItemException(TodoConstants.EMPTY_TITLE_OR_DESCRIPTION)
        }
        repo.addTodoItem(todo)
    }

    suspend fun updateTodoItem(todo: TodoItem){
        if(todo.title.isBlank() || todo.description.isBlank()){
            throw InvalidTodoItemException(TodoConstants.EMPTY_TITLE_OR_DESCRIPTION)
        }
        repo.updateTodoItem(todo)
    }

    suspend fun deleteTodoItem(todo: TodoItem){
        repo.deleteTodoItem(todo)
    }

    suspend fun toggleCompletedTodoItem(todo: TodoItem){
        repo.updateTodoItem(todo.copy(completed = !todo.completed))
    }

    suspend fun getTodoItemById(id: Int):TodoItem?{
        return repo.getSingleTodoItemById(id)
    }

    suspend fun getTodoItems(
        todoItemOrder: TodoItemOrder = TodoItemOrder.Time(SortingDirection.Down)
    ): TodoUseCaseResult{
        var todos = repo.getAllTodosFromLocalCache()
        if(todos.isEmpty()){
            todos = repo.getAllTodos()
        }

        

        return when(todoItemOrder.sortingDirection){
            is SortingDirection.Down -> {
                when(todoItemOrder){
                    is TodoItemOrder.Title -> TodoUseCaseResult.Success(todos.sortedByDescending { it.title.lowercase() })
                    is TodoItemOrder.Time -> TodoUseCaseResult.Success(todos.sortedByDescending { it.createdAt })
                    is TodoItemOrder.Completed -> TodoUseCaseResult.Success(todos.sortedByDescending { it.completed })
                }
            }
            is SortingDirection.Up -> {
                when(todoItemOrder){
                    is TodoItemOrder.Title -> TodoUseCaseResult.Success(todos.sortedBy { it.title.lowercase() })
                    is TodoItemOrder.Time -> TodoUseCaseResult.Success(todos.sortedBy { it.createdAt })
                    is TodoItemOrder.Completed -> TodoUseCaseResult.Success(todos.sortedBy { it.completed })
                }
            }
        }
    }

    suspend fun addUser(user: User){
        repo.addUser(user)
    }

    suspend fun getUserById(user: User):Map<String,User> {
        return repo.getUserById(user)
    }
}

sealed class TodoUseCaseResult{
    data class Success(val todoItems: List<TodoItem>):TodoUseCaseResult()
    data class Error(val message:String):TodoUseCaseResult()
}