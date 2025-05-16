package com.example.todo.feature_todo.data.mapper

import com.example.todo.feature_todo.data.local.dto.LocalTodoItem
import com.example.todo.feature_todo.data.remote.dto.RemoteTodoItem
import com.example.todo.feature_todo.domain.model.TodoItem

fun TodoItem.toLocalTodoItem(): LocalTodoItem {
    return LocalTodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun TodoItem.toRemoteTodoItem(): RemoteTodoItem {
    return RemoteTodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun LocalTodoItem.toTodoItem(): TodoItem {
    return TodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun LocalTodoItem.toRemoteTodoItem(): RemoteTodoItem {
    return RemoteTodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun RemoteTodoItem.toTodoItem(): TodoItem {
    return TodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun RemoteTodoItem.toLocalTodoItem(): LocalTodoItem {
    return LocalTodoItem(
        id = id,
        createdAt = createdAt,
        dueDate = dueDate,
        title = title,
        description = description,
        completed = completed,
        category = category,
        priority = priority
    )
}

fun List<TodoItem>.toRemoteTodoItemList(): List<RemoteTodoItem> {
    return this.map { todo ->
        RemoteTodoItem(
            id = todo.id,
            createdAt = todo.createdAt,
            dueDate = todo.dueDate,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            category = todo.category,
            priority = todo.priority
        )
    }
}

fun List<LocalTodoItem>.toTodoItemListFromLocal(): List<TodoItem> {
    return this.map { todo ->
        TodoItem(
            id = todo.id,
            createdAt = todo.createdAt,
            dueDate = todo.dueDate,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            category = todo.category,
            priority = todo.priority
        )
    }
}

fun List<LocalTodoItem>.toRemoteTodoItemListFromLocal(): List<RemoteTodoItem> {
    return this.map { todo ->
        RemoteTodoItem(
            id = todo.id,
            createdAt = todo.createdAt,
            dueDate = todo.dueDate,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            category = todo.category,
            priority = todo.priority
        )
    }
}

fun List<RemoteTodoItem>.toTodoItemListFromRemote(): List<TodoItem> {
    return this.map { todo ->
        TodoItem(
            id = todo.id,
            createdAt = todo.createdAt,
            dueDate = todo.dueDate,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            category = todo.category,
            priority = todo.priority
        )
    }
}

fun List<RemoteTodoItem>.toLocalTodoItemListFromRemote(): List<LocalTodoItem> {
    return this.map { todo ->
        LocalTodoItem(
            id = todo.id,
            createdAt = todo.createdAt,
            dueDate = todo.dueDate,
            title = todo.title,
            description = todo.description,
            completed = todo.completed,
            category = todo.category,
            priority = todo.priority
        )
    }
}