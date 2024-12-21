package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.feature_todo.domain.model.TodoItem

@Composable
fun TodoItemList(backgroundImage: Painter, todoItems:List<TodoItem>, isLoading:Boolean=false, error:String? = null){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Image(
            painter = backgroundImage,
            contentDescription = ContentDescriptions.BACKGROUND_IMAGE,
            alignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .padding(top = 64.dp)
            ) {
                items(todoItems){ todoItem ->
                    TodoItemCard(
                        todo=todoItem,
                        modifier = Modifier.fillMaxSize()
                            .padding(4.dp),
                        onDeleteClick = {},
                        onArchiveClick = {},
                        onCompleteClick = {},
                        onCardClick = {}
                    )
                }
            }
            if(isLoading){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.semantics {
                            this.contentDescription = ContentDescriptions.LOADING_INDICATOR
                        }
                    )
                }
            }
            if(error != null){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = error,
                        fontSize = 30.sp,
                        lineHeight = 36.sp
                    )
                }
            }
        }
    }
}