package com.example.todo.feature_todo.presentation.todo_new_update.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextInput(
    modifier: Modifier,
    textFieldModifier: Modifier = Modifier,
    text: String,
    placeholder: String,
    fontSize: TextUnit = 32.sp,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
    isHintVisible: Boolean = true,
    onFocusChange: (FocusState) -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = TextStyle(
                fontSize = fontSize,
                color = textColor
            ),
            modifier = textFieldModifier
                .fillMaxWidth()
                .onFocusChanged { onFocusChange(it) }
        )
        if (isHintVisible) {
            Text(
                text = placeholder,
                fontSize = fontSize,
                color = textColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoInputField() {
    TextInput(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.primary),
        text = "",
        placeholder = "Enter title...",
        fontSize = 24.sp,
        singleLine = true,
        onValueChange = { /* Handle text change */ },
        onFocusChange = { /* Handle focus state change */ }
    )
}