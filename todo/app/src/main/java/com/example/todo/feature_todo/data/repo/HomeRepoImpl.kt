package com.example.todo.feature_todo.data.repo

import android.util.Log
import com.example.todo.core.util.generateUuid
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.mapper.toLocalTodoItem
import com.example.todo.feature_todo.data.mapper.toLocalTodoItemListFromRemote
import com.example.todo.feature_todo.data.mapper.toRemoteTodoItem
import com.example.todo.feature_todo.data.mapper.toTodoItem
import com.example.todo.feature_todo.data.mapper.toTodoItemListFromLocal
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.HomeRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

class HomeRepoImpl(
    private val dao: TodoDao,
    private val api: TodoApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : HomeRepo {
    override suspend fun getAllTodos(userId: String):List<TodoItem>{
        getAllTodosFromRemote(userId)
        return dao.getAllTodoItems().toTodoItemListFromLocal()
    }

    override suspend fun getAllTodosFromLocalCache(): List<TodoItem>{
        return dao.getAllTodoItems().toTodoItemListFromLocal()
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
        val remoteTodos = api.getAllTodos(userId)
        val convertedRemoteTodos = convertToList(remoteTodos).filterNotNull()
        dao.addAllTodoItems(convertedRemoteTodos.toLocalTodoItemListFromRemote())
    }

    private fun convertToList(response:  Map<String, RemoteTodoItem>): List<RemoteTodoItem> {
        return response.values.toList()
    }

    private fun isCacheEmpty():Boolean{
        var isEmpty = true
        if(dao.getAllTodoItems().isNotEmpty()) isEmpty = false
        return isEmpty
    }

    override suspend fun getSingleTodoItemById(id: String): TodoItem?{
        return dao.getSingleTodoItemById(id)?.toTodoItem()
    }

    override suspend fun addTodoItem(user: User,todo: TodoItem){
        val url = "todos/${user.id}.json"
        val uuid = generateUuid()
        val newTodoItem = todo.toRemoteTodoItem().copy(id = uuid)
        api.addTodo(url, mapOf(uuid to newTodoItem))
    }

    override suspend fun updateTodoItem(user: User,todo: TodoItem){
        dao.addTodoItem(todo.toLocalTodoItem())
        api.updateTodoItem(user.id,todo.id,todo.toRemoteTodoItem())
    }

    override suspend fun deleteTodoItem(user: User,todo: TodoItem) {
        try{
            val response = api.deleteTodo(user.id,todo.id)
            if(response.isSuccessful){
                dao.deleteTodoItem(todo.toLocalTodoItem())
            }else{
                Log.i("API_DELETE","Response Unsuccessful")
                Log.i("API_DELETE",response.message())
            }
        }catch (e:Exception){
            when(e){
                is UnknownHostException, is ConnectException, is HttpException -> {
                    Log.e("HTTP", "Error: Could not delete")
                }else -> throw e
            }
        }
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
}