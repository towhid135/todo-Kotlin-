package com.example.todo.feature_todo.data.repo

import android.util.Log
import com.example.todo.core.util.ApiResult
import com.example.todo.core.util.safeApiFlow
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.mapper.toDomain
import com.example.todo.feature_todo.data.mapper.toTodoDomainList
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.CreateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.TodoItemDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import java.time.format.DateTimeFormatter

class HomeRepoImpl(
    private val dao: TodoDao,
    private val api: TodoApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : HomeRepo {
    override  fun getAllTodos(userId: Long): Flow<ApiResult<List<TodoItem>>>{
        Log.d("HomeRepoImpl", "getAllTodos called for userId: $userId")
        return safeApiFlow(
            apiCall = {
                Log.d("HomeRepoImpl", "Making API call to getAllTodos")
                api.getAllTodos(userId)
            },
            mapper = {dto ->
                Log.d("HomeRepoImpl", "Mapper called with ${dto.size} items from API")
                dto.toTodoDomainList()
            }
        )
    }

    override fun createTodo(todo: TodoItem): Flow<ApiResult<TodoItem>> {
        // Convert ZonedDateTime to UTC RFC3339 (e.g. "2026-06-13T00:00:00Z").
        // ZonedDateTime.toString() appends "[Asia/Dhaka]" which Go's time.Time
        // JSON parser cannot handle — it only accepts RFC3339 / ISO-8601 offset format.
        val utcFormatter = DateTimeFormatter.ISO_INSTANT
        val createDto = CreateTodoRequestDto(
            userId = todo.userId,
            title = todo.title,
            description = todo.description,
            categoryId = todo.category.id,
            priority = todo.priority,
            completed = todo.completed,
            dueDate = utcFormatter.format(todo.dueDate.toInstant())
        )
        return safeApiFlow(
            apiCall = { api.createTodo(createDto) },
            mapper = { dto -> dto.toDomain() }
        )
    }

    override fun updateTodo(todo: TodoItem): Flow<ApiResult<TodoItem>> {
        val utcFormatter = DateTimeFormatter.ISO_INSTANT
        val updateDto = UpdateTodoRequestDto(
            id = todo.id,
            title = todo.title,
            description = todo.description,
            categoryId = todo.category.id,
            priority = todo.priority,
            completed = todo.completed,
            dueDate = utcFormatter.format(todo.dueDate.toInstant())
        )
        return safeApiFlow(
            apiCall = { api.updateTodo(updateDto) },
            mapper = { dto -> dto.toDomain(todo) }
        )
    }

    override suspend fun getAllTodosFromLocalCache(): List<TodoItem>{
        return emptyList()
    }

    override suspend fun getAllTodosFromRemote(userId: String){
        return withContext(dispatcher){
            try {
                refreshRoomCache(userId)
            }catch (e: Exception){
                when(e){
                    is UnknownHostException, is ConnectException, is HttpException -> {
                        Log.e("HTTP","Error: No data from remote")
                        if(isCacheEmpty()){
                            Log.e("Cache", "Error: No data from local room cache")
                            throw Exception("Error: Device offline and\nno data from local room.")
                        }
                    }
                }
            }
        }
    }

    private suspend fun refreshRoomCache(userId:String){

    }

    private fun convertToList(response:  Map<String, TodoItemDto>): List<TodoItemDto> {
        return response.values.toList()
    }

    private fun isCacheEmpty():Boolean{
        var isEmpty = true
        if(dao.getAllTodoItems().isNotEmpty()) isEmpty = false
        return isEmpty
    }

    override fun getTodoById(id: Long): Flow<ApiResult<TodoItem>> {
        return safeApiFlow(
            apiCall = { api.getTodoItemById(id) },
            mapper = { dto -> dto.toDomain() }
        )
    }

    override suspend fun addTodoItem(user: User,todo: TodoItem){

    }

    override suspend fun updateTodoItem(user: User,todo: TodoItem){

    }

    override suspend fun deleteTodoItem(user: User,todo: TodoItem) {

    }

    override suspend fun addUser(user: Map<String,User>) {
        val id = user.keys.first()
        val url = "users/$id.json"
        api.addUser(url = url, user=user)
    }

    override suspend fun getUserByMail(email: String):User {
        val userRes = api.getUserByMail(email)
        return userRes
    }

    override suspend fun clearAllTodoItems(){
        dao.clearAllTodoItems()
    }

    override suspend fun updateUser(email: String, user: User) {
        api.updateUser(email,user)
    }

    override suspend fun getTodosByDateRange(userId: Long, startAt: Long, endAt: Long): List<TodoItem> {
        return emptyList()
    }
}