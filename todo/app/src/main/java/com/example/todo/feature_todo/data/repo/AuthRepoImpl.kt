package com.example.todo.feature_todo.data.repo

import android.util.Log
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.remote.dto.User
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.feature_todo.domain.use_case.SignInResponse
import com.example.todo.feature_todo.domain.use_case.SignInResult
import com.example.todo.feature_todo.domain.use_case.SignupResult
import com.google.firebase.auth.FirebaseAuth
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
                    id = user.uid,
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


    override suspend fun firebaseLoginWithEmailAndPassword(
        email: String,
        password: String
    ): SignInResult {
        return try {
            val loginRes = auth.signInWithEmailAndPassword(email, password).await()
            val user = loginRes.user
            if (user != null) {
                val response = SignInResponse(
                    email = user.email ?: "",
                    localId = user.uid
                )
                SignInResult.Success(response)
            } else {
                SignInResult.Error("User is null")
            }
        } catch (e: Exception) {
            SignInResult.Error(e.message ?: "Something went wrong")
        }
    }

    override suspend fun signOut() {
        auth.signOut()
    }
}


