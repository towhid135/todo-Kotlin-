package com.example.todo.feature_todo.domain.repo

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    fun register(request: SignupRequest): Flow<ApiResult<SignupResult>>
    fun verifyOtp(email: String, otp: String): Flow<ApiResult<Unit>>
    fun login(email: String, password: String): Flow<ApiResult<LoginResult>>
    suspend fun signOut()
}