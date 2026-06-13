package com.example.todo.feature_todo.domain.use_case

import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.core.util.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthUseCases @Inject constructor(private val repo: AuthRepo) {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): SignupResult {
        return repo.firebaseSignUpWithEmailAndPassword(email,password)
    }

    suspend fun login(email: String, password: String): Flow<ApiResult<LoginResult>> {
        return repo.login(email,password)
    }

    suspend fun signOut(){
        return repo.signOut()
    }
}

data class SignInResponse(
    val email: String,
    val localId: String
)

sealed class SignupResult {
    data class Success(val isSuccess: Boolean): SignupResult()
    data class Error(val message: String): SignupResult()
}

sealed class SignInResult {
    data class Success(val data: SignInResponse): SignInResult()
    data class Error(val message: String): SignInResult()
}

