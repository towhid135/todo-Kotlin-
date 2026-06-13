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
import com.example.todo.core.util.Category
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.domain.model.TodoItem
import com.example.todo.feature_todo.presentation.category.components.ChooseCategoryDialog
import com.example.todo.feature_todo.presentation.category.components.ChoosePriorityDialog
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
    newTodo: TodoItem,
    sheetState: SheetState,
    showBottomSheet: Boolean,
    toggleShowBottomSheet: () -> Unit,
    scope: CoroutineScope,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onCategoryChange: (category: Category) -> Unit,
    onPriorityChange: (priority: Priority) -> Unit,
    onChangeDueDate: (dueDate: Long) -> Unit,
    onPressAddTodo: (newTodo: TodoItem) -> Unit,
) {
    val theme = LocalTheme.current

    var showDatePicker by remember { mutableStateOf(false) }

    var showCategory by remember { mutableStateOf(false) }
    var showPriority by remember { mutableStateOf(false) }

    fun toggleShowDatePicker() {
        showDatePicker = !showDatePicker
    }

    fun toggleShowCategory() {
        showCategory = !showCategory
    }

    fun toggleShowPriority() {
        showPriority = !showPriority
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
                    text = newTodo.title,
                    placeholderText = "Enter title",
                    onValueChange = { onTitleChange(it) }
                )
                CustomTextInput(
                    labelText = "Description",
                    text = newTodo.description,
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
                            modifier = Modifier.clickable { toggleShowCategory() },
                            imageVector = Todoz.Tag,
                            contentDescription = null,
                            tint = theme.colors.iconPrimary,
                        )
                        Icon(
                            modifier = Modifier.clickable { toggleShowPriority() },
                            imageVector = Todoz.Flag,
                            contentDescription = null,
                            tint = theme.colors.iconPrimary,
                        )
                    }
                    Icon(
                        modifier = Modifier.clickable {
                            onPressAddTodo(newTodo)
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

    // convert ZonedDateTime dueDate to epoch millis for the DatePicker (which expects Long?)
    val initialSelectedMillis: Long? = try {
        newTodo.dueDate.toInstant().toEpochMilli()
    } catch (e: Exception) {
        null
    }

    // map Int priority to Priority enum
    val selectedPriority: Priority = when (newTodo.priority) {
        1 -> Priority.LOW
        2 -> Priority.MEDIUM
        3 -> Priority.HIGH
        else -> Priority.MEDIUM
    }

    TodoDatePickerModal(
        initialSelectedDateMillis = initialSelectedMillis,
        showDatePicker = showDatePicker,
        toggleShowDatePicker = { toggleShowDatePicker() },
        onChangeDueDate = { onChangeDueDate(it) }
    )

    ChooseCategoryDialog(
        showCategory = showCategory,
        selectedCategory = newTodo.category,
        toggleShowCategory = { toggleShowCategory() },
        onCategoryChange = { onCategoryChange(it) }
    )

    ChoosePriorityDialog(
        showPriority = showPriority,
        toggleShowPriority = { toggleShowPriority() },
        selectedPriority = selectedPriority,
        onPriorityChange = { onPriorityChange(it) }
    )

}