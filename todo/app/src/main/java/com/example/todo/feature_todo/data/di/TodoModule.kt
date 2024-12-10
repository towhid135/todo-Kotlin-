package com.example.todo.feature_todo.data.di

import android.content.Context
import androidx.room.Room
import com.example.todo.BuildConfig
import com.example.todo.feature_todo.data.local.TodoDao
import com.example.todo.feature_todo.data.local.TodoDatabase
import com.example.todo.feature_todo.data.remote.TodoApi
import com.example.todo.feature_todo.data.repo.TodoListRepoImpl
import com.example.todo.feature_todo.domain.repo.TodoListRepo
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Provides
    fun providesRetrofitApi(retrofit: Retrofit):TodoApi{
        return retrofit.create(TodoApi::class.java)
    }

    @Provides
    @Singleton
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(BuildConfig.BASE_URL)
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
    fun providesTodoRepo(db: TodoDatabase, api: TodoApi, @IoDispatcher dispatcher:CoroutineDispatcher): TodoListRepo{
        return TodoListRepoImpl(db.dao,api,dispatcher)
    }

}