package com.example.todo.core.presentation.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.IconAsset
import com.example.todo.core.util.TodoProfileStrings
import com.example.todo.ui.theme.LocalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileImagePicker(
    showBottomSheet: Boolean,
    sheetState: SheetState,
    toggleShowBottomSheet: () -> Unit,
    onGalleryImageSelected: (uri: Uri) -> Unit,
    onCameraImageCaptured: (uri: Uri) -> Unit,
    onDismiss: () -> Unit
){
    val theme = LocalTheme.current

    if(showBottomSheet){
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            onDismissRequest = { toggleShowBottomSheet() },
            sheetState = sheetState,
            containerColor = theme.colors.backgroundSecondary,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
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
                    containerColor = theme.colors.secondary,
                    type = ButtonType.FILLED,
                    size = ButtonSize.LARGE,
                    title = ButtonTitle.GALLERY,
                    leftIcon = IconAsset.GALLERY,
                    onPress = {}
                )
                CustomButton(
                    containerColor = theme.colors.secondary,
                    type = ButtonType.FILLED,
                    size = ButtonSize.LARGE,
                    title = ButtonTitle.CAMERA,
                    leftIcon = IconAsset.CAMERA_MODERN,
                    onPress = {}
                )
            }
        }
    }
}



