package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.domain.use_case.SignInResult
import com.example.todo.feature_todo.domain.use_case.SignupResult


interface AuthRepo {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): SignupResult
    suspend fun firebaseLoginWithEmailAndPassword(email: String, password: String): SignInResult
    suspend fun signOut()
}