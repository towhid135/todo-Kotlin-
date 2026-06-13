package com.example.todo.feature_todo.data.mapper

import com.example.todo.core.util.Category
import com.example.todo.feature_todo.data.remote.dto.CategoryDto
import com.example.todo.feature_todo.data.remote.dto.LoginResponseData
import com.example.todo.feature_todo.data.remote.dto.TodoItemDto
import com.example.todo.feature_todo.data.remote.dto.UpdateTodoResponseDto
import com.example.todo.feature_todo.domain.model.LoginResult
import com.example.todo.feature_todo.domain.model.TodoItem
import java.time.ZonedDateTime


fun LoginResponseData.toDomain(): LoginResult {
    return LoginResult(
        id = id,
        name = name,
        email = email,
        isVerified = isVerified,
        imageUrl = imageUrl,
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}

fun TodoItemDto.toDomain(): TodoItem {
    fun parseZoned(str: String?): ZonedDateTime {
        return try {
            if (str.isNullOrBlank()) ZonedDateTime.now() else ZonedDateTime.parse(str)
        } catch (_: Exception) {
            ZonedDateTime.now()
        }
    }

    return TodoItem(
        id = id ?: 0L,
        userId = userId ?: 0L,
        title = title ?: "",
        description = description ?: "",
        category = category?.toDomain() ?: Category(
            id = 0L,
            title = "",
            bgColor = "",
            icon = ""
        ),
        priority = priority ?: 1,
        completed = completed ?: false,
        createdAt = parseZoned(createdAt),
        dueDate = parseZoned(dueDate)
    )
}

fun TodoItem.toDto(): TodoItemDto {
    return TodoItemDto(
        id = id,
        userId = userId,
        title = title,
        description = description,
        category = category.toDto(),
        priority = priority,
        completed = completed,
        // convert ZonedDateTime to ISO string for DTO
        createdAt = try { createdAt.toString() } catch (_: Exception) { null },
        dueDate = try { dueDate.toString() } catch (_: Exception) { null }
    )
}

fun CategoryDto.toDomain(): Category {
    return Category(
        id = id ?: 0L,
        title = title ?: "",
        bgColor = bgColor ?: "",
        icon = icon ?: ""
    )
}

fun Category.toDto(): CategoryDto {
    return CategoryDto(
        id = id,
        title = title,
        bgColor = bgColor,
        icon = icon
    )
}

fun UpdateTodoResponseDto.toDomain(originalTodo: TodoItem): TodoItem {
    fun parseZoned(str: String?): ZonedDateTime {
        return try {
            if (str.isNullOrBlank()) ZonedDateTime.now() else ZonedDateTime.parse(str)
        } catch (_: Exception) {
            ZonedDateTime.now()
        }
    }

    return TodoItem(
        id = id,
        userId = originalTodo.userId,
        title = title,
        description = description,
        category = originalTodo.category,
        priority = priority,
        completed = completed,
        createdAt = originalTodo.createdAt,
        dueDate = parseZoned(dueDate)
    )
}


// Note: give unique names to list mapping functions to avoid JVM signature clashes
fun List<TodoItemDto>.toTodoDomainList(): List<TodoItem> {
    android.util.Log.d("TodoMapper", "toTodoDomainList called with ${this.size} items")
    this.forEachIndexed { index, dto ->
        android.util.Log.d("TodoMapper", "Item $index: id=${dto.id}, title=${dto.title}, category=${dto.category}")
    }
    val result = this.map {
        val mapped = it.toDomain()
        android.util.Log.d("TodoMapper", "Mapped: id=${mapped.id}, title=${mapped.title}, category=${mapped.category}")
        mapped
    }
    android.util.Log.d("TodoMapper", "toTodoDomainList returning ${result.size} items")
    return result
}

@Suppress("unused")
fun List<TodoItem>.toTodoDtoList(): List<TodoItemDto> {
    return this.map { it.toDto() }
}

@Suppress("unused")
fun List<CategoryDto>.toCategoryDomainList(): List<Category> {
    return this.map { it.toDomain() }
}

@Suppress("unused")
fun List<Category>.toCategoryDtoList(): List<CategoryDto> {
    return this.map { it.toDto() }
}