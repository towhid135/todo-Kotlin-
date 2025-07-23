package com.example.todo.feature_todo.presentation.category.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.core.util.Priority
import com.example.todo.feature_todo.presentation.home.components.PriorityBox
import com.example.todo.ui.theme.LocalTheme

@Composable
fun PriorityItem(priority: Priority,isSelected:Boolean,onPress:(priority:Priority) -> Unit){
    val theme = LocalTheme.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPress(priority) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            isSelected, onClick = { onPress(priority) }, colors = RadioButtonDefaults.colors(
                selectedColor = theme.colors.iconPrimary,
                unselectedColor = theme.colors.iconPrimary
            )
        )
        PriorityBox(
            priority = priority,
        )
    }

}

@Composable
fun ChoosePriorityDialog(
    showPriority: Boolean,
    toggleShowPriority: () -> Unit,
    selectedPriority: Priority,
    onPriorityChange: (priority: Priority) -> Unit
) {
    val theme = LocalTheme.current

    fun onPriorityBoxPress(priority: Priority) {
        onPriorityChange(priority)
    }

    if (showPriority) {
        Dialog(onDismissRequest = {toggleShowPriority()}) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .background(
                        color = theme.colors.borderSecondary,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(vertical = 15.dp, horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PriorityItem(Priority.LOW, isSelected = selectedPriority == Priority.LOW, onPress = { onPriorityBoxPress(it) })
                PriorityItem(Priority.MEDIUM, isSelected = selectedPriority == Priority.MEDIUM, onPress = { onPriorityBoxPress(it) })
                PriorityItem(Priority.HIGH, selectedPriority == Priority.HIGH, onPress = { onPriorityBoxPress(it) })
                CustomButton(
                    type = ButtonType.FILLED,
                    size = ButtonSize.MEDIUM,
                    title = ButtonTitle.CLOSE,
                    onPress = { toggleShowPriority() }
                )
            }
        }
    }
}