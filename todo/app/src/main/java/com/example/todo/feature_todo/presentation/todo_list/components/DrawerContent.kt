package com.example.todo.feature_todo.presentation.todo_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.core.util.TodoListStrings
import com.example.todo.feature_todo.domain.util.TodoItemOrder

@Composable
fun DrawerContent(todoItemOrder: TodoItemOrder, onOrderChange:(TodoItemOrder) -> Unit){
    Box(modifier = Modifier.fillMaxWidth(0.65f)){
        ModalDrawerSheet {
            Text(
                text = TodoListStrings.SORT_BY,
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