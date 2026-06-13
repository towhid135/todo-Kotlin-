package com.example.todo.feature_todo.data.di

import android.content.Context
import androidx.room.Room
import com.example.todo.BuildConfig
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.local.TodoDatabase
import com.example.todo.feature_todo.data.network.interceptor.HeaderInterceptor
import com.example.todo.feature_todo.data.network.interceptor.TokenAuthenticator
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.repo.AuthRepoImpl
import com.example.todo.feature_todo.data.repo.HomeRepoImpl
import com.example.todo.feature_todo.domain.repo.AuthRepo
import com.example.todo.feature_todo.domain.repo.HomeRepo
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Provides
    @Singleton
    fun provideHeaderInterceptor(
        @ApplicationContext context: Context
    ): HeaderInterceptor = HeaderInterceptor(context)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

    @Provides
    @Singleton
    fun provideTokenAuthenticator(
        api: Lazy<TodoApi>,
        @ApplicationContext context: Context
    ): TokenAuthenticator = TokenAuthenticator(
        api = api,
        context = context
    )

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)    // logs before the auth header is added
        .addInterceptor(headerInterceptor)     // attaches Authorization header
        .authenticator(tokenAuthenticator)     // handles 401 globally
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
    @Provides
    fun providesRetrofitApi(retrofit: Retrofit):TodoApi{
        return retrofit.create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    @Provides
    fun providesRoomDao(database: TodoDatabase):TodoDao{
        return database.dao
    }

    @Provides
    @Singleton
    fun providesRoomDb(@ApplicationContext appContext: Context):TodoDatabase{
        return Room.databaseBuilder(
            appContext.applicationContext,
            TodoDatabase::class.java,
            "todo_database"
        ).fallbackToDestructiveMigrationFrom().build()
    }

    @Provides
    @Singleton
    fun providesTodoRepo(db: TodoDatabase, api: TodoApi, @IoDispatcher dispatcher:CoroutineDispatcher): HomeRepo{
        return HomeRepoImpl(db.dao,api,dispatcher)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(api: TodoApi):AuthRepo = AuthRepoImpl(auth = Firebase.auth, api)

}