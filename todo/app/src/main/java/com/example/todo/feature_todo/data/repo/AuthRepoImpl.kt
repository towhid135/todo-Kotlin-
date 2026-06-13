package com.example.todo.feature_todo.data.repo

import android.util.Log
import com.example.todo.feature_todo.data.mapper.toDomain
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.feature_todo.domain.use_case.SignInResponse
import com.example.todo.feature_todo.domain.use_case.SignInResult
import com.example.todo.feature_todo.domain.use_case.SignupResult
import com.example.todo.core.util.ApiResult
import com.example.todo.core.util.safeApiFlow
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class AuthRepoImpl(
    private val auth: FirebaseAuth,
    private val api: TodoApi
) : AuthRepo {
    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String
    ): SignupResult {
        return try {
            val signupRes = auth.createUserWithEmailAndPassword(email, password).await()
            val user = signupRes.user
            if(user != null) {
                val emailAsKey = user.email?.split("@")[0] ?: ""
                val url = "/users.json"
                val user = User(
                    id = 1L,
                    name = "",
                    email = emailAsKey
                )
                api.addUser(url,mapOf(emailAsKey to user))
                SignupResult.Success(true)
            }else{
                SignupResult.Error("no user found")
            }
        } catch (e: Exception) {
            SignupResult.Error(e.message ?: "Something went wrong")
        }
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
           mapper = {dto -> dto.toDomain() }
       )
    }

    override suspend fun signOut() {
        auth.signOut()
    }
}


