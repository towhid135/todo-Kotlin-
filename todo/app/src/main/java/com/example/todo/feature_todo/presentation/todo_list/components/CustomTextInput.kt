package com.example.todo.feature_todo.presentation.todo_list.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextInput(
    text: String = "",
    isSecureField: Boolean = false,
    placeholderText: String = "",
    labelText: String = "",
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector? = null
) {
    TextField(
        modifier = Modifier,
        value = text,
        label = if (labelText.isNotEmpty()) {
            { Text(
                text = labelText,
                fontSize = 14.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            ) }
        } else null,
        placeholder = {
            Text(
                text = placeholderText,
                fontSize = 10.sp,
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            )
        },
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Gray,
            unfocusedContainerColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        visualTransformation = if (isSecureField) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(24.dp, 24.dp),
                    imageVector = it,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextInputPreview() {
    CustomTextInput(
        text = "Username",
        placeholderText = "Enter text here",
        onValueChange = {}
    )
}