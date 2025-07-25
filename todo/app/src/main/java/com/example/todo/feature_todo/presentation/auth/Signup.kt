package com.example.todo.feature_todo.presentation.auth

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.AuthStrings
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.IconAsset
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.theme.LocalTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Signup(
    onLoginClick: () -> Unit = { }
) {
    val theme = LocalTheme.current
    Scaffold(
        modifier = Modifier.background(theme.colors.backgroundPrimary),
        topBar = {
            TodoListScreenTopAppBar(
                leftIcon = Icons.AutoMirrored.Filled.ArrowBackIos,
                onLeftIconClick = { })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Text(
                text = AuthStrings.REGISTER,
                color = theme.colors.textPrimary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
            CustomTextInput(
                labelText = AuthStrings.USER_NAME,
                text = "",
                placeholderText = AuthStrings.USER_NAME_PLACEHOLDER,
                onValueChange = { }
            )
            CustomTextInput(
                isSecureField = true,
                labelText = AuthStrings.PASSWORD,
                text = "",
                placeholderText = AuthStrings.PASSWORD_PLACEHOLDER,
                onValueChange = { }
            )
            CustomTextInput(
                isSecureField = true,
                labelText = AuthStrings.CONFIRM_PASSWORD,
                text = "",
                placeholderText = AuthStrings.CONFIRM_PASSWORD_PLACEHOLDER,
                onValueChange = { }
            )

            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_LARGE,
                title = ButtonTitle.REGISTER,
                onPress = {}
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 0.5.dp,
                    color = theme.colors.borderSecondary
                )
                Text(
                    text = AuthStrings.OR,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textTertiary
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 0.5.dp,
                    color = theme.colors.borderSecondary
                )

            }
            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_LARGE,
                title = ButtonTitle.REGISTER_WITH_GOOGLE,
                leftIcon = IconAsset.GOOGLE_LOGIN,
                onPress = {}
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 2.dp),
                    text = AuthStrings.ALREADY_HAVE_AN_ACCOUNT,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textTertiary
                )

                Text(
                    modifier = Modifier.clickable { onLoginClick()},
                    text = AuthStrings.LOG_IN,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textPrimary
                )

            }
        }
    }
}