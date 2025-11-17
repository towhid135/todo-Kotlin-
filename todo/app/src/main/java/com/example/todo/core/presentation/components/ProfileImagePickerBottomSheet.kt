package com.example.todo.core.presentation.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.FileUtils
import com.example.todo.core.util.IconAsset
import com.example.todo.core.util.ImageUtils
import com.example.todo.core.util.TodoProfileStrings
import com.example.todo.ui.theme.LocalTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ProfileImagePickerBottomSheet(
    showBottomSheet: Boolean,
    sheetState: SheetState,
    toggleShowBottomSheet: () -> Unit,
    onGalleryImageSelected: (uri: Uri) -> Unit,
    onCameraImageCaptured: (uri: Uri) -> Unit,
    onDismiss: () -> Unit
) {
    val theme = LocalTheme.current
    val context = LocalContext.current

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var tempImageFile by remember { mutableStateOf<File?>(null) }

    var cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    val galleryLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                onGalleryImageSelected(it)
                selectedImageUri = it
            }
        }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { result ->
        if(result && selectedImageUri != null) {
            onCameraImageCaptured(selectedImageUri!!)
        }
    }

    fun onGalleryClick() {
        galleryLauncher.launch("image/*")
        toggleShowBottomSheet()
    }

    fun launchCamera(){
        val tempImageFile = FileUtils.getTempImageFile(context)
        val uri = ImageUtils.getFileProviderUri(context,tempImageFile)
        selectedImageUri = uri
        cameraLauncher.launch(uri)
    }

    fun onCameraClick(){
        if(cameraPermissionState.status.isGranted){
            launchCamera()
        }else{
            cameraPermissionState.launchPermissionRequest()
        }
        toggleShowBottomSheet()
    }

    LaunchedEffect(cameraPermissionState.status) {
        if (cameraPermissionState.status.isGranted) {
            if (selectedImageUri == null) {
                launchCamera()
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { toggleShowBottomSheet() },
            sheetState = sheetState,
            containerColor = theme.colors.backgroundSecondary,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = TodoProfileStrings.CHANGE_PROFILE_PICTURE,
                    fontSize = 16.sp,
                    color = theme.colors.textPrimary,
                    fontFamily = FontFamily.SansSerif,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                CustomButton(
                    containerColor = theme.colors.buttonSecondary,
                    type = ButtonType.FILLED,
                    size = ButtonSize.LARGE,
                    title = ButtonTitle.GALLERY,
                    leftIcon = IconAsset.GALLERY,
                    onPress = { onGalleryClick() }
                )
                CustomButton(
                    containerColor = theme.colors.buttonPrimary,
                    type = ButtonType.FILLED,
                    size = ButtonSize.LARGE,
                    title = ButtonTitle.CAMERA,
                    leftIcon = IconAsset.CAMERA_MODERN,
                    onPress = {onCameraClick()}
                )
            }
        }
    }
}



