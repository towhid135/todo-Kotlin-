package com.example.todo.core.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.core.util.ContentDescriptions
import com.example.todo.ui.theme.TodoTheme


@Composable
fun CompleteButton(
    onCompleteClick: () -> Unit,
    color: Color,
    completed:Boolean,
    modifier: Modifier = Modifier
){
    IconButton(onClick = onCompleteClick, modifier = Modifier) {
        if(completed){
           Icon(
               imageVector = Icons.Default.CheckCircleOutline,
               contentDescription = ContentDescriptions.COMPLETE_TODO_ITEM,
               tint = color,
               modifier = Modifier.size(40.dp)
           )
        }else{
            EmptyCircle(color=color)
        }
    }
}

@Composable
fun EmptyCircle(color:Color,strokeWidth:Float = 9f){
    Canvas(modifier = Modifier.fillMaxSize()) {
        val radius = 34.0f
        drawCircle(
            color,
            center = center,
            radius = radius,
            style = Stroke(width = strokeWidth)
        )
    }
}

@Composable
fun ArchiveButton(
    onArchiveClick: () -> Unit,
    color:Color = MaterialTheme.colorScheme.secondary,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onArchiveClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Archive,
            contentDescription = ContentDescriptions.ARCHIVE_TODO_ITEM,
            tint = color,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun DeleteButton(
    onDeleteClick:() -> Unit,
    modifier:Modifier = Modifier
){
    IconButton(
        onClick = onDeleteClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = ContentDescriptions.DELETE_TODO_ITEM,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview
@Composable
fun ButtonsPreview(){
    TodoTheme {
        Column {
            CompleteButton(
                onCompleteClick = { print("completed")},
                color = MaterialTheme.colorScheme.onSecondary,
                completed = true
            )
            ArchiveButton(
                onArchiveClick = { print("archive press") }
            )
            DeleteButton(onDeleteClick = { print("delete") })
        }
    }
}