package com.example.todo.feature_todo.data.remote.dto

import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.google.gson.annotations.SerializedName

data class RemoteTodoItem (
    @SerializedName("ID")
    val id: String,
    @SerializedName("CreatedAt")
    val createdAt:Long,
    @SerializedName("Title")
    val title:String,
    @SerializedName("Description")
    val  description:String,
    @SerializedName("Completed")
    val completed:Boolean,
    @SerializedName("Category")
    val category: Category,
    @SerializedName("Priority")
    val priority: Priority
)