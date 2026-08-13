package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.model.SignupRequest
import com.example.todo.feature_todo.domain.model.SignupResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: AuthRepo) {
    operator fun invoke(request: SignupRequest): Flow<ApiResult<SignupResult>> {
        return repository.register(request)
    }
}
