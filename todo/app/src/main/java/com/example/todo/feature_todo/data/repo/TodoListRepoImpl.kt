package com.example.todo.feature_todo.data.repo

import android.util.Log
import com.example.todo.feature_todo.data.di.IoDispatcher
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.mapper.toLocalTodoItem
import com.example.todo.feature_todo.data.mapper.toLocalTodoItemListFromRemote
import com.example.todo.feature_todo.data.mapper.toRemoteTodoItem
import com.example.todo.feature_todo.data.mapper.toTodoItem
import com.example.todo.feature_todo.data.mapper.toTodoItemListFromLocal
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

class TodoListRepoImpl(
    private val dao: TodoDao,
    private val api: TodoApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : TodoListRepo {
    override suspend fun getAllTodos():List<TodoItem>{
        getAllTodosFromRemote()
        return dao.getAllTodoItems().toTodoItemListFromLocal()
    }

    override suspend fun getAllTodosFromLocalCache(): List<TodoItem>{
        return dao.getAllTodoItems().toTodoItemListFromLocal()
    }

    override suspend fun getAllTodosFromRemote(){
        return withContext(dispatcher){
            try {
                refreshRoomCache()
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

    private suspend fun refreshRoomCache(){
        val remoteTodos = api.getAllTodos().filterNotNull()
        dao.addAllTodoItems(remoteTodos.toLocalTodoItemListFromRemote())
    }

    private fun isCacheEmpty():Boolean{
        var isEmpty = true
        if(dao.getAllTodoItems().isNotEmpty()) isEmpty = false
        return isEmpty
    }

    override suspend fun getSingleTodoItemById(id: Int): TodoItem?{
        return dao.getSingleTodoItemById(id)?.toTodoItem()
    }

    override suspend fun addTodoItem(todo: TodoItem){
        val newId = dao.addTodoItem(todo.toLocalTodoItem())
        val id = newId.toInt()
        val url = "todo/$id.json"
        api.addTodo(url,todo.toRemoteTodoItem().copy(id = id))
    }

    override suspend fun updateTodoItem(todo: TodoItem){
        dao.addTodoItem(todo.toLocalTodoItem())
        api.updateTodoItem(todo.id,todo.toRemoteTodoItem())
    }

    override suspend fun deleteTodoItem(todo: TodoItem) {
        try{
            val response = api.deleteTodo(todo.id)
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
}