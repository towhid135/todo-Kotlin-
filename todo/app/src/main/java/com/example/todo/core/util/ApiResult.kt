package com.example.todo.core.util

sealed class ApiResult<out T> {
    data class Loading<T>(val data: T? = null) : ApiResult<T>()
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error<T>(val message: String) : ApiResult<T>()
}