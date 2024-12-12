package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.todo.ui.theme.TodoTheme

@Composable
fun DrawerItem(
    text:String = "",
    isChecked:Boolean = false,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        
    ) {
        Text(
            text=text,
            fontSize = 24.sp,
            lineHeight = 30.sp
        )
        if(isChecked){
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

@Preview
@Composable
fun DrawerItemPreview(){
    TodoTheme {
        DrawerItem(
            text = "Sort Item",
            isChecked=true
        )
    }
}