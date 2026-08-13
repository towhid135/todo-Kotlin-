package com.example.todo.feature_todo.presentation.otp.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OtpInput(
    otp: String,
    onOtpChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 6,
) {
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = otp,
        onValueChange = { value ->
            val filtered = value
                .filter(Char::isDigit)
                .take(length)

            onOtpChange(filtered)
        },
        modifier = modifier
            .focusRequester(focusRequester),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
        ),
        interactionSource = interactionSource,
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(length) { index ->

                    val digit = otp.getOrNull(index)?.toString() ?: ""
                    val isFocused = otp.length == index

                    OtpBox(
                        digit = digit,
                        isFocused = isFocused,
                    )
                }
            }
        }
    )
}