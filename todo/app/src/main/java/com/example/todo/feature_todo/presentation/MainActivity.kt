package com.example.todo.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.core.presentation.components.CustomButton
import com.example.todo.core.util.ButtonSize
import com.example.todo.core.util.ButtonTitle
import com.example.todo.core.util.ButtonType
import com.example.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        CustomButton(type = ButtonType.FILLED, size = ButtonSize.LARGE,title = ButtonTitle.LOGIN, isEnabled = true, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.FILLED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = false, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.OUTLINED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = true, onPress = {})
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(type = ButtonType.OUTLINED, size = ButtonSize.LARGE,title = ButtonTitle.GET_STARTED, isEnabled = false, onPress = {})
                    }
                }
            }
        }
    }
}
