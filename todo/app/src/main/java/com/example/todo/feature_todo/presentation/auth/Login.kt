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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.AuthStrings
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.IconAsset
import com.example.todo.feature_todo.presentation.auth.viewmodel.AuthViewModel
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.theme.LocalTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Login(
    authViewModel: AuthViewModel = hiltViewModel(),
    onRegisterClick: () -> Unit
) {
    val theme = LocalTheme.current
    val state by authViewModel.state
    Scaffold(
        topBar = {
            TodoListScreenTopAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(theme.colors.backgroundPrimary)
                .fillMaxHeight()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Text(
                text = AuthStrings.LOG_IN,
                color = theme.colors.textPrimary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
            CustomTextInput(
                labelText = AuthStrings.EMAIL,
                text = state.email,
                placeholderText = AuthStrings.USER_NAME_PLACEHOLDER,
                onValueChange = { authViewModel.onEvent(AuthEvent.OnEmailChange(it)) }
            )
            CustomTextInput(
                isSecureField = true,
                labelText = AuthStrings.PASSWORD,
                text = state.password,
                placeholderText = AuthStrings.PASSWORD_PLACEHOLDER,
                onValueChange = { authViewModel.onEvent(AuthEvent.OnPasswordChange(it)) }
            )

            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_LARGE,
                title = ButtonTitle.LOGIN,
                onPress = { authViewModel.onEvent(AuthEvent.OnLoginClick) }
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
                title = ButtonTitle.LOGIN_WITH_GOOGLE,
                leftIcon = IconAsset.GOOGLE_LOGIN,
                onPress = {}
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 2.dp),
                    text = AuthStrings.DONT_HAVE_AN_ACCOUNT,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textTertiary
                )

                Text(
                    modifier = Modifier.clickable { onRegisterClick() },
                    text = AuthStrings.REGISTER,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textPrimary
                )

            }
        }
    }
}