package com.example.todo.feature_todo.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.todo.ui.theme.LocalTheme

@Composable
fun ProfileImage(
    imageUrl: String,
    onImageClick: () -> Unit,
) {
    val theme = LocalTheme.current
    Box(
        modifier = Modifier.clickable {onImageClick()}
    ) {
        if (imageUrl.isNotEmpty()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "User Profile Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape), 
                contentScale = ContentScale.Crop
            )
        } else {

            Icon(
                modifier = Modifier
                    .size(height = 100.dp, width = 100.dp),
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null,
                tint = theme.colors.iconPrimary
            )
        }
        Column(
            modifier = Modifier
                .background(color = theme.colors.primary, shape = CircleShape)
                .size(height = 32.dp, width = 32.dp)
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(height = 20.dp, width = 20.dp),
                imageVector = Icons.Default.PhotoCamera,
                contentDescription = null,
                tint = theme.colors.iconPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileImagePreview() {
    ProfileImage(
        imageUrl = "", // Pass an empty string for the preview
        onImageClick = {} // Pass an empty lambda for the click action
    )
}
