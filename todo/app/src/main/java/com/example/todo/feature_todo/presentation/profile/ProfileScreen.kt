package com.example.todo.feature_todo.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.CommonDialog
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.presentation.components.LoadingModal
import com.example.todo.core.presentation.components.ProfileImagePickerBottomSheet
import com.example.todo.core.util.AuthStrings
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.TodoProfileStrings
import com.example.todo.feature_todo.presentation.auth.AuthEvent
import com.example.todo.feature_todo.presentation.home.components.CustomTextInput
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.profile.components.LogoutButton
import com.example.todo.feature_todo.presentation.profile.components.ProfileImage
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel<ProfileViewModel>()
) {
    val theme = LocalTheme.current
    val profileState = profileViewModel.state.value
    var showLogoutDialog by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    var showBottomSheet by remember { mutableStateOf(false) }

    fun toggleShowBottomSheet() {
        showBottomSheet = !showBottomSheet
    }

    LaunchedEffect(true) {
        profileViewModel.uiEventFlow.collectLatest { event ->
            when (event) {
                ProfileViewModel.UiEvent.LogoutButton -> {
                    showLogoutDialog = !showLogoutDialog
                }
            }
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TodoListScreenTopAppBar(
                title = TodoProfileStrings.TITLE,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = theme.colors.backgroundPrimary)
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            ProfileImage(
                imageUrl = profileState.profileImageUrl,
                onImageClick = { toggleShowBottomSheet() }
            )

            CustomTextInput(
                labelText = TodoProfileStrings.NAME,
                text = profileState.name,
                placeholderText = TodoProfileStrings.USER_NAME_PLACEHOLDER,
                onValueChange = { profileViewModel.onEvent(ProfileEvent.OnNameChange(it))  }
            )
            CustomTextInput(
                enabled = false,
                labelText = TodoProfileStrings.EMAIL,
                text = profileState.email,
                placeholderText = TodoProfileStrings.EMAIL_PLACEHOLDER,
                onValueChange = { profileViewModel.onEvent(ProfileEvent.OnEmailChange(it)) },
            )

            CustomButton(
                isLoading = profileState.isLoading,
                isEnabled = !profileState.isLoading,
                type = ButtonType.FILLED,
                size = ButtonSize.LARGE,
                title = ButtonTitle.SAVE_CHANGES,
                onPress = { profileViewModel.onEvent(ProfileEvent.OnSubmitProfileChanges) }
            )

            LogoutButton(
                onClick = { profileViewModel.onUiEvent(ProfileViewModel.UiEvent.LogoutButton) }
            )

            CommonDialog(
                showDialog = showLogoutDialog,
                title = TodoProfileStrings.LOGOUT_TITLE,
                message = TodoProfileStrings.LOGOUT_MESSAGE,
                negativeButtonName = TodoProfileStrings.CANCEL,
                positiveButtonName = TodoProfileStrings.LOG_OUT,
                onNegativeActionClick = { showLogoutDialog = false },
            ) {
                profileViewModel.onEvent(ProfileEvent.Logout)
                showLogoutDialog = false
            }

            ProfileImagePickerBottomSheet(
                showBottomSheet = showBottomSheet,
                sheetState = sheetState,
                toggleShowBottomSheet = { toggleShowBottomSheet() },
                onImageSelected = { profileViewModel.onEvent(ProfileEvent.EditProfileImage(it)) },
            ) {
                toggleShowBottomSheet()
            }

            LoadingModal(profileState.isProfileGetApiLoading)

        }

    }
}