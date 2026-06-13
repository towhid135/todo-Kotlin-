package com.example.todo.feature_todo.data.remote

import com.example.todo.core.util.ApiResponseDto
import com.example.todo.feature_todo.data.remote.dto.CreateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.LoginResponseData
import com.example.todo.feature_todo.data.remote.dto.RefreshAccessTokenDto
import com.example.todo.feature_todo.data.remote.dto.TodoItemDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoResponseDto
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
    @POST(ApiEndpoints.LOGIN_URL)
    suspend fun login(@Body body: Map<String, String>): ApiResponseDto<LoginResponseData>
    @POST(ApiEndpoints.REFRESH_ACCESS_TOKEN_URL)
    suspend fun refreshAccessToken(@Body body: Map<String, String>): Response<RefreshAccessTokenDto>

    @GET(ApiEndpoints.GET_ALL_TODOS_BY_USER_ID)
    suspend fun getAllTodos(
        @Query("userId") userId: Long
    ): ApiResponseDto<List<TodoItemDto>>

    @POST(ApiEndpoints.CREATE_TODO_URL)
    suspend fun createTodo(@Body todo: CreateTodoRequestDto): ApiResponseDto<TodoItemDto>

    @PUT("/api/v1/todos")
    suspend fun updateTodo(
        @Body todo: UpdateTodoRequestDto
    ): ApiResponseDto<UpdateTodoResponseDto>

    @GET("/api/v1/todos/{id}")
    suspend fun getTodoItemById(@Path("id") id: Long): ApiResponseDto<TodoItemDto>

//    @POST
//    suspend fun addTodo(@Url url:String, @Body updatedTodo:TodoItemDto):Response<Unit>

    @PATCH
    suspend fun addTodo(@Url url:String, @Body updatedTodo:Map<String,TodoItemDto>):Response<Unit>

    @DELETE("/todos/{userId}/{todoId}.json")
    suspend fun deleteTodo(@Path("userId") userId: String,@Path("todoId") todoId : String?) : Response<Unit>

    @PUT("/todos/{userId}/{id}.json")
    suspend fun updateTodoItem(@Path("userId") userId: String,@Path("id") id: String?, @Body todoItem:TodoItemDto):Response<Unit>

    @PATCH
    suspend fun addUser(@Url url: String, @Body user: Map<String,User>)

    @PATCH("/users/{email}.json")
    suspend fun updateUser(@Path("email") email: String, @Body user: User)

    @GET("/users/{email}/.json")
    suspend fun getUserByMail(@Path("email") email: String): User

    @GET("todos/{userId}.json")
    suspend fun getTodosByDateRange(
        @Path("userId") userId: String,
        @Query("orderBy") orderBy: String = "\"dueDate\"",
        @Query("startAt") startAt: Long, // Start of the day timestamp
        @Query("endAt") endAt: Long      // End of the day timestamp
    ): Map<String, TodoItemDto>
}