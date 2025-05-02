package com.example.todo.feature_todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todo.core.util.CategoryTypeConverter
import com.example.todo.core.util.PriorityTypeConverter
import com.example.todo.feature_todo.data.local.dto.LocalTodoItem

@Database(
    entities = [LocalTodoItem::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CategoryTypeConverter::class, PriorityTypeConverter::class)
abstract class TodoDatabase:RoomDatabase() {
    abstract val dao:TodoDao

    companion object{
        const val DATABASE_NAME = "todo_db"
    }
}