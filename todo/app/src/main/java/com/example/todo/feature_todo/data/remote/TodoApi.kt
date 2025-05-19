package com.example.todo.feature_todo.data.remote

import androidx.room.Delete
import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import com.example.todo.feature_todo.data.remote.dto.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface TodoApi {
    @GET("/todos.json")
    suspend fun getAllTodos(): List<RemoteTodoItem>

    @GET("/todos.json?orderBy=\"ID\"")
    suspend fun getTodoItemById(@Query("equalTo") id: String?): Map<String,RemoteTodoItem>

//    @POST
//    suspend fun addTodo(@Url url:String, @Body updatedTodo:RemoteTodoItem):Response<Unit>

    @PUT
    suspend fun addTodo(@Url url:String, @Body updatedTodo:RemoteTodoItem):Response<Unit>

    @DELETE("/todo/{id}.json")
    suspend fun deleteTodo(@Path("id") id : String?) : Response<Unit>

    @PUT("/todo/{id}.json")
    suspend fun updateTodoItem(@Path("id") id: String?, @Body todoItem:RemoteTodoItem):Response<Unit>

    @POST
    suspend fun addUser(@Url url: String, @Body user:User)

    @GET("/users.json?orderBy=\"ID\"")
    suspend fun getUserById(@Query("equalTo") id: String?): Map<String,User>
}