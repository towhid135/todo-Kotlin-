package com.example.todo.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.todo.core.util.DialogStrings
import com.example.todo.ui.theme.LocalTheme

@Composable
fun CommonDialog(
    showDialog:Boolean=false,
    title:String,
    message:String,
    negativeButtonName: String = DialogStrings.CANCEL,
    positiveButtonName: String = DialogStrings.DELETE,
    onNegativeActionClick: () -> Unit,
    onPositiveActionClick:() -> Unit
){
    val theme = LocalTheme.current

    if(showDialog){

        Dialog(onDismissRequest = onNegativeActionClick) {
            Column(
                modifier = Modifier.background(theme.colors.dialogBackgroundPrimary, shape = RoundedCornerShape(12.dp))
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                title.let {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        color = theme.colors.dialogTextPrimary,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                message.let {
                    Text(
                        text = message,
                        fontSize = 16.sp,
                        color = theme.colors.dialogTextPrimary,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = onNegativeActionClick,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = theme.colors.textSecondary,
                            disabledContentColor = theme.colors.textTertiary
                        )
                    ) {
                        Text(
                            text = negativeButtonName,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    TextButton(
                        onClick = onPositiveActionClick,
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = theme.colors.error,
                            disabledContentColor = theme.colors.textTertiary
                        )
                    ) {
                        Text(
                            text = positiveButtonName,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

}