package com.example.todo.feature_todo.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.core.presentation.components.CommonDialog
import com.example.todo.core.presentation.components.ProfileImagePickerBottomSheet
import com.example.todo.core.util.TodoProfileStrings
import com.example.todo.feature_todo.presentation.home.components.TodoListScreenTopAppBar
import com.example.todo.feature_todo.presentation.profile.components.ProfileImage
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Trash
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel<ProfileViewModel>()
) {
    val theme = LocalTheme.current
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
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ProfileImage(
                imageUrl = "",
                onImageClick = {toggleShowBottomSheet()}
            )
            Row(
                modifier = Modifier.clickable { profileViewModel.onUiEvent(ProfileViewModel.UiEvent.LogoutButton) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .size(25.dp),
                    imageVector = Todoz.Trash,
                    contentDescription = null,
                    tint = theme.colors.error,
                )
                Text(
                    text = TodoProfileStrings.LOG_OUT,
                    fontSize = 14.sp,
                    color = theme.colors.error,
                    fontFamily = FontFamily.SansSerif,
                )
            }

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
                onGalleryImageSelected = { /*TODO*/ },
                onCameraImageCaptured = { /*TODO*/ }
            ) {
                toggleShowBottomSheet()
            }

        }

    }
}