package com.example.todo.feature_todo.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.util.TodoItemOrder
import com.example.todo.ui.theme.LocalTheme

@Composable
fun DrawerContent(todoItemOrder: TodoItemOrder, onOrderChange:(TodoItemOrder) -> Unit){
    val theme = LocalTheme.current
    Box(modifier = Modifier.fillMaxWidth(0.65f)){
        ModalDrawerSheet(
            drawerContainerColor = theme.colors.backgroundPrimary
        ) {
            Text(
                text = TodoListStrings.SORT_BY,
                color = theme.colors.textPrimary,
                modifier = Modifier.padding(16.dp),
                fontSize = 34.sp,
                lineHeight = 18.sp
            )
            HorizontalDivider()
            DrawerOptions(
                todoItemOrder = todoItemOrder,
                onOrderChange = onOrderChange
            )
        }
    }
}