package com.example.todo.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.ui.theme.TodoTheme

@Composable
fun CustomButton(
    type: ButtonType = ButtonType.FILLED,
    size: ButtonSize = ButtonSize.LARGE,
    title: ButtonTitle = ButtonTitle.LOGIN,
    leftIcon: Int? = null,
    rightIcon: Int? = null,
    isEnabled: Boolean = true,
    onPress: () -> Unit
) {
    val buttonWidth = when (size) {
        ButtonSize.SMALL -> 90.dp
        ButtonSize.MEDIUM -> 150.dp
        ButtonSize.LARGE -> 300.dp
    }
    val buttonHeight = 48.dp

    when (type) {
        ButtonType.FILLED -> {
            FilledTonalButton(
                modifier = Modifier
                    .width(buttonWidth)
                    .height(buttonHeight),
                onClick = { onPress },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface
                ),
                shape = RoundedCornerShape(5.dp),
                enabled = isEnabled
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    leftIcon?.let {
                        Image(
                            painter = painterResource(it),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = title.value,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    rightIcon?.let {
                        Image(
                            painter = painterResource(it),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }

        ButtonType.OUTLINED -> {
            OutlinedButton(
                modifier = Modifier
                    .width(buttonWidth)
                    .height(buttonHeight),
                onClick = { onPress },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(
                    1.dp,
                    color = if (isEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                ),
                enabled = isEnabled

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    leftIcon?.let {
                        Image(
                            painter = painterResource(it),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = title.value,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    rightIcon?.let {
                        Image(
                            painter = painterResource(it),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }


}


@Preview
@Composable
fun ButtonsPreview() {
    TodoTheme {
        Column {
            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.LARGE,
                title = ButtonTitle.LOGIN,
                onPress = {})
            CustomButton(
                type = ButtonType.OUTLINED,
                size = ButtonSize.LARGE,
                title = ButtonTitle.LOGIN,
                isEnabled = true,
                onPress = {})
        }
    }
}