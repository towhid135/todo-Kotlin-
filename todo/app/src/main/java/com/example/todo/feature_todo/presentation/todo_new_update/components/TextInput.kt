package com.example.todo.feature_todo.presentation.todo_new_update.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoInputField(
    modifier:Modifier,
    text:String,
    placeholder: @Composable (() -> Unit)? = null,
    fontSize: TextUnit = 32.sp,
    textColor:Color = MaterialTheme.colorScheme.onPrimary,
    singleLine:Boolean = true,
    onValueChange:(String) -> Unit,
    onFocuschange: (FocusState) -> Unit
){
    Column(modifier = modifier) {
        TextField(
            value = text,
            placeholder = placeholder,
            singleLine = singleLine,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
                .onFocusChanged { onFocuschange(it) }
                .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(20.dp))
            ,
            textStyle = TextStyle(
                fontSize = fontSize,
                color = textColor
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoInputField() {
    TodoInputField(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.primary),
        text = "",
        placeholder = { Text(text = "Enter your task...") },
        fontSize = 24.sp,
        singleLine = true,
        onValueChange = { /* Handle text change */ },
        onFocuschange = { /* Handle focus state change */ }
    )
}