package com.example.todo.feature_todo.domain.util

sealed class TodoItemOrder(
    val sortingDirection: SortingDirection
){
    class Title(sortingDirection: SortingDirection):TodoItemOrder(sortingDirection)
    class Time(sortingDirection: SortingDirection):TodoItemOrder(sortingDirection)
    class Completed(sortingDirection: SortingDirection):TodoItemOrder(sortingDirection)

    fun copy(sortingDirection: SortingDirection):TodoItemOrder{
        return when(this){
            is Title -> Title(sortingDirection)
            is Time -> Time(sortingDirection)
            is Completed -> Completed(sortingDirection)
        }
    }
}