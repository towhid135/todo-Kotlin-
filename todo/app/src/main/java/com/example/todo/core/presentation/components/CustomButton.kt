package com.example.todo.core.presentation.components

import android.annotation.SuppressLint
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.IconAsset
import com.example.todo.ui.theme.LocalTheme
import com.example.todo.ui.theme.TodoTheme

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CustomButton(
    type: ButtonType = ButtonType.FILLED,
    size: ButtonSize = ButtonSize.LARGE,
    title: ButtonTitle = ButtonTitle.REGISTER_WITH_GOOGLE,
    leftIcon: IconAsset? = null,
    rightIcon: IconAsset? = null,
    isEnabled: Boolean = true,
    onPress: () -> Unit,
    isLoading: Boolean = false
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val extraLargeButtonWidth = screenWidth - (2 * 24) // 24.dp padding on each side
    val theme = LocalTheme.current
    val buttonWidth = when (size) {
        ButtonSize.SMALL -> 90.dp
        ButtonSize.MEDIUM -> 150.dp
        ButtonSize.LARGE -> 300.dp
        ButtonSize.EXTRA_LARGE -> extraLargeButtonWidth.dp
    }
    val buttonHeight = 48.dp

    when (type) {
        ButtonType.FILLED -> {
            FilledTonalButton(
                modifier = Modifier
                    .width(buttonWidth)
                    .height(buttonHeight),
                onClick = { onPress() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = theme.colors.primary,
                    disabledContainerColor = theme.colors.secondary,
                    contentColor = theme.colors.textPrimary,
                    disabledContentColor = theme.colors.textPrimary
                ),
                shape = RoundedCornerShape(5.dp),
                enabled = isEnabled
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = theme.colors.textPrimary
                        )
                    } else {
                        leftIcon?.id?.let {
                            Image(
                                painter = painterResource(it),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Text(
                            text = title.value,
                            fontSize = 16.sp,
                            color = theme.colors.textPrimary
                        )
                        rightIcon?.id?.let {
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

        ButtonType.OUTLINED -> {
            OutlinedButton(
                modifier = Modifier
                    .width(buttonWidth)
                    .height(buttonHeight),
                onClick = { onPress },
                colors = ButtonDefaults.buttonColors(
                    containerColor = theme.colors.backgroundPrimary,
                    contentColor = theme.colors.textPrimary,
                    disabledContainerColor = theme.colors.secondary,
                    disabledContentColor = theme.colors.textPrimary
                ),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(
                    1.dp,
                    color = if (isEnabled) theme.colors.primary else theme.colors.buttonPrimary
                ),
                enabled = isEnabled

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = theme.colors.textPrimary
                        )
                    } else {
                        leftIcon?.id?.let {
                            Image(
                                painter = painterResource(it),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Text(
                            text = title.value,
                            fontSize = 16.sp,
                            color = theme.colors.textPrimary
                        )
                        rightIcon?.id?.let {
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


}


@Preview
@Composable
fun ButtonsPreview() {
    TodoTheme {
        Column {
            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.LARGE,
                title = ButtonTitle.REGISTER_WITH_GOOGLE,
                leftIcon = IconAsset.GOOGLE_LOGIN,
                onPress = {})
            CustomButton(
                isLoading = true,
                isEnabled = false,
                type = ButtonType.FILLED,
                size = ButtonSize.LARGE,
                title = ButtonTitle.REGISTER_WITH_GOOGLE,
                leftIcon = IconAsset.GOOGLE_LOGIN,
                onPress = {})

        }
    }
}