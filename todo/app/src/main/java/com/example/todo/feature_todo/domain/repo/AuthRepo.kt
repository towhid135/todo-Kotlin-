package com.example.todo.feature_todo.domain.repo

import com.example.todo.feature_todo.domain.use_case.AuthResult


interface AuthRepo {
    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String):AuthResult
    suspend fun firebaseLoginWithEmailAndPassword(email: String, password: String):AuthResult
    suspend fun signOut()
}