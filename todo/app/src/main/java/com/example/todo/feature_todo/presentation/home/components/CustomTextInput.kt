package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.ui.theme.LocalTheme

@Composable
fun CustomTextInput(
    text: String = "",
    isSecureField: Boolean = false,
    placeholderText: String = "",
    labelText: String = "",
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onEyeButtonPress: () -> Unit = {}
) {
    val theme = LocalTheme.current
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        textStyle = TextStyle(
            color = theme.colors.textPrimary,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif
        ),
        label = if (labelText.isNotEmpty()) {
            {
                Text(
                    text = labelText,
                    fontSize = 14.sp,
                    color = theme.colors.textPrimary,
                    fontFamily = FontFamily.SansSerif
                )
            }
        } else null,
        placeholder = {
            Text(
                text = placeholderText,
                fontSize = 10.sp,
                color = theme.colors.placeHolderPrimary,
                fontFamily = FontFamily.SansSerif
            )
        },
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = theme.colors.textInputBackgroundPrimary,
            unfocusedContainerColor = theme.colors.textInputBackgroundPrimary,
            focusedIndicatorColor = theme.colors.transparent,
            unfocusedIndicatorColor = theme.colors.transparent,
            disabledIndicatorColor = theme.colors.transparent,
        ),
        visualTransformation = if (isSecureField) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    modifier = Modifier.size(24.dp, 24.dp),
                    imageVector = it,
                    contentDescription = null,
                    tint = theme.colors.iconSecondary,
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                Icon(
                    modifier = Modifier
                        .clickable(
                            onClick = onEyeButtonPress
                        )
                        .size(24.dp, 24.dp),
                    imageVector = it,
                    contentDescription = null,
                    tint = theme.colors.iconSecondary,
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