package com.example.todo.core.util
import com.google.gson.annotations.SerializedName

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T, R> safeApiFlow(
    apiCall: suspend () -> ApiResponseDto<T>,
    mapper: (T) -> R
): Flow<ApiResult<R>> = flow {

    emit(ApiResult.Loading())

    try {
        val response = apiCall()

        if (response.status && response.data != null) {
            emit(ApiResult.Success(mapper(response.data)))
        } else {
            emit(ApiResult.Error(response.message ?: "Unknown error"))
        }

    } catch (e: Exception) {
        emit(ApiResult.Error(e.message ?: "Network error"))
    }
}

fun <T> safeApiNoDataFlow(
    apiCall: suspend () -> ApiResponseDto<T>
): Flow<ApiResult<Unit>> = flow {
    emit(ApiResult.Loading())
    try {
        val response = apiCall()
        if (response.status) {
            emit(ApiResult.Success(Unit))
        } else {
            emit(ApiResult.Error(response.message ?: "Unknown error"))
        }
    } catch (e: Exception) {
        emit(ApiResult.Error(e.message ?: "Network error"))
    }
}


data class ApiResponseDto<T>(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("code")
    val code: String?,

    @SerializedName("data")
    val data: T?,

    @SerializedName(value = "message", alternate = ["Message"])
    val message: String?
)