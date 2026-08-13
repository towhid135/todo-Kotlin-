package com.example.todo.feature_todo.domain.use_case

import com.example.todo.core.util.ApiResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(
    private val repository: AuthRepo
) {
    operator fun invoke(email: String, otp: String): Flow<ApiResult<Unit>> {
        return repository.verifyOtp(email, otp)
    }
}
