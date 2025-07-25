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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import com.example.todo.feature_todo.presentation.auth.viewmodel.AuthViewModel
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Signup(
    authViewModel: AuthViewModel,
    onBackButtonClick: () -> Unit,
    onLoginClick: () -> Unit = { }
) {
    val state by authViewModel.state
    val theme = LocalTheme.current

    LaunchedEffect(true) {
        authViewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                AuthViewModel.UiEvent.BackButton -> onBackButtonClick()
            }
        }
    }

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
                labelText = AuthStrings.EMAIL,
                text = state.email,
                placeholderText = AuthStrings.USER_NAME_PLACEHOLDER,
                onValueChange = { authViewModel.onEvent(AuthEvent.onEmailChange(it)) }
            )
            CustomTextInput(
                isSecureField = true,
                labelText = AuthStrings.PASSWORD,
                text = state.password,
                placeholderText = AuthStrings.PASSWORD_PLACEHOLDER,
                onValueChange = { authViewModel.onEvent(AuthEvent.onPasswordChange(it)) }
            )
            CustomTextInput(
                isSecureField = true,
                labelText = AuthStrings.CONFIRM_PASSWORD,
                text = state.confirmPassword,
                placeholderText = AuthStrings.CONFIRM_PASSWORD_PLACEHOLDER,
                onValueChange = { authViewModel.onEvent(AuthEvent.onConfirmPasswordChange(it)) }
            )

            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_LARGE,
                title = ButtonTitle.REGISTER,
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
                    modifier = Modifier.clickable { onLoginClick() },
                    text = AuthStrings.LOG_IN,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = theme.colors.textPrimary
                )

            }
        }
    }
}