package com.example.todo.feature_todo.data.remote

import com.example.todo.core.util.ApiResponseDto
import com.example.todo.feature_todo.data.remote.dto.CreateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.LoginResponseData
import com.example.todo.feature_todo.data.remote.dto.RefreshAccessTokenDto
import com.example.todo.feature_todo.data.remote.dto.TodoItemDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoRequestDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoResponseDto
import com.example.todo.feature_todo.data.remote.dto.UpdateUserRequestDto
import com.example.todo.feature_todo.data.remote.dto.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoApi {
    @POST(ApiEndpoints.LOGIN_URL)
    suspend fun login(@Body body: Map<String, String>): ApiResponseDto<LoginResponseData>

    @POST(ApiEndpoints.REFRESH_ACCESS_TOKEN_URL)
    suspend fun refreshAccessToken(@Body body: Map<String, String>): ApiResponseDto<RefreshAccessTokenDto>

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

    @DELETE("/api/v1/todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Long): ApiResponseDto<Unit?>

    // User endpoints (Go backend)
    @GET(ApiEndpoints.GET_USER_URL)
    suspend fun getUser(): ApiResponseDto<User>

    @PUT(ApiEndpoints.UPDATE_USER_URL)
    suspend fun updateUser(@Body body: UpdateUserRequestDto): ApiResponseDto<User>

    @DELETE("/api/v1/auth/signout")
    suspend fun signout(): ApiResponseDto<Unit?>
}