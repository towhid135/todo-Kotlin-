package com.example.todo.feature_todo.domain.util

sealed class TodoItemOrder(
    val sortingDirection: SortingDirection,
    val showArchived: Boolean
){
    class Title(sortingDirection: SortingDirection,showArchived: Boolean):TodoItemOrder(sortingDirection,showArchived)
    class Time(sortingDirection: SortingDirection,showArchived: Boolean):TodoItemOrder(sortingDirection,showArchived)
    class Completed(sortingDirection: SortingDirection,showArchived: Boolean):TodoItemOrder(sortingDirection,showArchived)

    fun copy():TodoItemOrder{
        return when(this){
            is Title -> Title(this.sortingDirection,this.showArchived);
            is Time -> Time(this.sortingDirection,this.showArchived);
            is Completed -> Time(this.sortingDirection,this.showArchived)
        }
    }
}