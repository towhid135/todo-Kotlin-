package com.example.todo.feature_todo.data.repo

import com.example.todo.core.util.ApiResult
import com.example.todo.core.util.safeApiFlow
import com.example.todo.core.util.safeApiNoDataFlow
import com.example.todo.feature_todo.data.mapper.toDomain
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.SignupRequestDto
import com.example.todo.feature_todo.data.remote.dto.VerifyOtpRequestDto
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
class AuthRepoImpl(
    private val auth: FirebaseAuth,
    private val api: TodoApi
) : AuthRepo {

    override fun register(request: SignupRequest): Flow<ApiResult<SignupResult>> {
        return safeApiFlow(
            apiCall = {
                api.register(
                    SignupRequestDto(
                        email = request.email,
                        password = request.password
                    )
                )
            },
            mapper = { dto -> dto.toDomain() }
        )
    }

    override fun verifyOtp(email: String, otp: String): Flow<ApiResult<Unit>> {
        return safeApiNoDataFlow(
            apiCall = {
                api.verifyOtp(
                    VerifyOtpRequestDto(
                        email = email,
                        otp = otp
                    )
                )
            }
        )
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
