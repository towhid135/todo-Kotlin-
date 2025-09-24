package com.example.todo.feature_todo.domain.use_case

import com.example.todo.feature_todo.domain.repo.AuthRepo
import javax.inject.Inject

class AuthUseCases @Inject constructor(private val repo: AuthRepo) {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String):AuthResult{
        return repo.firebaseSignUpWithEmailAndPassword(email,password)
    }
}

sealed class AuthResult {
    data class Success(val isSuccess: Boolean): AuthResult()
    data class Error(val message: String): AuthResult()
}

