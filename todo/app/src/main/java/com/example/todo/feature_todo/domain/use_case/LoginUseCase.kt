package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.model.LoginRequest
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepo) {
    operator fun invoke(payload: LoginRequest): Flow<ApiResult<LoginResult>> {
        return repository.login(payload.email, payload.password)
    }
}