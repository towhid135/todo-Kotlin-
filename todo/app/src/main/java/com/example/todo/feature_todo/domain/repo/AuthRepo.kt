package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.use_case.SignInResult
import com.example.todo.feature_todo.domain.use_case.SignupResult
import com.example.todo.core.util.ApiResult
import kotlinx.coroutines.flow.Flow


interface AuthRepo {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): SignupResult
    fun login(email: String, password: String): Flow<ApiResult<LoginResult>>
    suspend fun signOut()
}