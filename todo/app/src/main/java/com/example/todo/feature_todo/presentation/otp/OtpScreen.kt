package com.example.todo.feature_todo.presentation.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.otp.components.OtpInput
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OtpScreen(
    otpViewModel: OtpViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    onSubmit: () -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val theme = LocalTheme.current
    val state by otpViewModel.state.collectAsState()

    LaunchedEffect(true) {
        otpViewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                OtpUiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(message = state.error, actionLabel = "Dismiss")
                }
                OtpUiEvent.NavigateToNextScreen -> {
                    onSubmit()
                }
                OtpUiEvent.NavigateBack -> {
                    onNavigateBack()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TodoListScreenTopAppBar(
                leftIcon = Icons.AutoMirrored.Filled.ArrowBackIos,
                onLeftIconClick = { otpViewModel.onActionEvent(OtpActionEvent.OnBackClick) }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
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
                text = "Enter OTP",
                color = theme.colors.textPrimary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
            OtpInput(
                otp = state.otp,
                onOtpChange = { otpViewModel.onActionEvent(OtpActionEvent.OnOtpChange(it)) },
                length = 6
            )
            CustomButton(
                type = ButtonType.FILLED,
                size = ButtonSize.EXTRA_LARGE,
                title = ButtonTitle.SUBMIT,
                onPress = {
                    otpViewModel.onActionEvent(OtpActionEvent.OnSubmitClick)
                },
                isLoading = state.isLoading,
                isEnabled = !state.isLoading
            )
        }
    }
}

