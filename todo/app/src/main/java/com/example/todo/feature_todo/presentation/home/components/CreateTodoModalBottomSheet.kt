package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.ui.icons.Todoz
import com.example.todo.ui.icons.todoz.Clock
import com.example.todo.ui.icons.todoz.Flag
import com.example.todo.ui.icons.todoz.Send
import com.example.todo.ui.icons.todoz.Tag
import com.example.todo.ui.theme.LocalTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTodoModalBottomSheet(
    title: String = "",
    description: String = "",
    sheetState: SheetState,
    showBottomSheet: Boolean,
    toggleShowBottomSheet: () -> Unit,
    scope: CoroutineScope,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
) {
    val theme = LocalTheme.current

    var showDatePicker by remember { mutableStateOf(false) }

    fun toggleShowDatePicker() {
        showDatePicker = !showDatePicker
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            onDismissRequest = { toggleShowBottomSheet() },
            sheetState = sheetState,
            containerColor = theme.colors.backgroundSecondary,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                CustomTextInput(
                    labelText = "Title",
                    text = title,
                    placeholderText = "Enter title",
                    onValueChange = { onTitleChange(it) }
                )
                CustomTextInput(
                    labelText = "Description",
                    text = description,
                    placeholderText = "Enter description",
                    onValueChange = { onDescriptionChange(it) }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.clickable {
                                toggleShowDatePicker()
                            },
                            imageVector = Todoz.Clock,
                            contentDescription = null,
                            tint = theme.colors.iconPrimary,
                        )
                        Icon(
                            modifier = Modifier.clickable { },
                            imageVector = Todoz.Tag,
                            contentDescription = null,
                            tint = theme.colors.iconPrimary,
                        )
                        Icon(
                            modifier = Modifier.clickable { },
                            imageVector = Todoz.Flag,
                            contentDescription = null,
                            tint = theme.colors.iconPrimary,
                        )
                    }
                    Icon(
                        modifier = Modifier.clickable {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    toggleShowBottomSheet()
                                }
                            }
                        },
                        imageVector = Todoz.Send,
                        contentDescription = null,
                        tint = theme.colors.buttonPrimary,
                    )
                }
            }
        }
    }

    TodoDatePickerModal(
        showDatePicker = showDatePicker,
        toggleShowDatePicker = { toggleShowDatePicker() }
    )

}