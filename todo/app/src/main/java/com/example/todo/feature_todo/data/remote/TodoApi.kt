package com.example.todo.feature_todo.data.remote

import androidx.room.Delete
import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import com.example.todo.feature_todo.data.remote.dto.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface TodoApi {
    @GET("/todos/{userId}/.json")
    suspend fun getAllTodos(@Path("userId") userId:String): Map<String, RemoteTodoItem>

    @GET("/todos.json?orderBy=\"ID\"")
    suspend fun getTodoItemById(@Query("equalTo") id: String?): Map<String,RemoteTodoItem>

//    @POST
//    suspend fun addTodo(@Url url:String, @Body updatedTodo:RemoteTodoItem):Response<Unit>

    @PATCH
    suspend fun addTodo(@Url url:String, @Body updatedTodo:Map<String,RemoteTodoItem>):Response<Unit>

    @DELETE("/todos/{userId}/{todoId}.json")
    suspend fun deleteTodo(@Path("userId") userId: String,@Path("todoId") todoId : String?) : Response<Unit>

    @PUT("/todos/{userId}/{id}.json")
    suspend fun updateTodoItem(@Path("userId") userId: String,@Path("id") id: String?, @Body todoItem:RemoteTodoItem):Response<Unit>

    @PATCH
    suspend fun addUser(@Url url: String, @Body user: Map<String,User>)

    @PATCH("/users/{email}.json")
    suspend fun updateUser(@Path("email") email: String, @Body user: User)

    @GET("/users/{email}/.json")
    suspend fun getUserByMail(@Path("email") email: String): User
}