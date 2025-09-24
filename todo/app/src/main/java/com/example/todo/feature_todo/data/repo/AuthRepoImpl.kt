package com.example.todo.feature_todo.data.repo
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.feature_todo.domain.use_case.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Singleton

@Singleton
class AuthRepoImpl(
    private val auth: FirebaseAuth
) : AuthRepo {
    override suspend fun firebaseSignUpWithEmailAndPassword(
        email: String,
        password: String
    ):AuthResult {
        return try {
            val signupRes = auth.createUserWithEmailAndPassword(email, password).await()
            AuthResult.Success(signupRes.user != null)
        }catch (e:Exception){
            AuthResult.Error(e.message ?: "Something went wrong")
        }
    }
}


