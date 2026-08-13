package com.example.todo.feature_todo.data.repo

import com.example.todo.core.util.ApiResult
import com.example.todo.core.util.safeApiFlow
import com.example.todo.feature_todo.data.mapper.toDomain
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.SignupRequestDto
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

@Singleton
class AuthRepoImpl(
    private val auth: FirebaseAuth,
    private val api: TodoApi
) : AuthRepo {

    override fun register(request: SignupRequest): Flow<ApiResult<SignupResult>> = flow {
        emit(ApiResult.Loading())
        try {
            val response = api.register(
                SignupRequestDto(
                    email = request.email,
                    password = request.password
                )
            )
            emit(ApiResult.Success(response.toDomain()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e.message ?: "Registration failed"))
        }
    }

    override fun login(
        email: String,
        password: String
    ): Flow<ApiResult<LoginResult>> {
        val reqBody = mapOf(
            "email" to email,
            "password" to password
        )
        return safeApiFlow(
            apiCall = { api.login(reqBody) },
            mapper = { dto -> dto.toDomain() }
        )
    }

    override suspend fun signOut() {
        auth.signOut()
    }
}
