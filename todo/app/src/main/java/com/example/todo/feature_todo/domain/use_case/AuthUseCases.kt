package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthUseCases @Inject constructor(private val repo: AuthRepo) {
    fun register(request: SignupRequest): Flow<ApiResult<SignupResult>> {
        return repo.register(request)
    }

    fun verifyOtp(email: String, otp: String): Flow<ApiResult<Unit>> {
        return repo.verifyOtp(email, otp)
    }

    fun login(email: String, password: String): Flow<ApiResult<LoginResult>> {
        return repo.login(email, password)
    }

    suspend fun signOut() {
        return repo.signOut()
    }
}
