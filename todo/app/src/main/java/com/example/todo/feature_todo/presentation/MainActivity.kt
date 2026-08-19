package com.example.todo.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.todo.navigation_graph.graphs.RootNavGraph
import com.example.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val splashScreen = installSplashScreen()

        var isAnimationCompleted = false

        // Keep the splash screen visible until the animation is complete
        splashScreen.setKeepOnScreenCondition { !isAnimationCompleted }

        val splashJob = lifecycleScope.launch {
            // Simulate the animation duration (match with your animation duration)
            delay(1200) // 1000ms = 1 second
            isAnimationCompleted = true
        }

        splashScreen.setOnExitAnimationListener {
            splashJob.cancel() // Cancel the coroutine when splash screen is hidden
            it.remove() // Remove the splash screen
        }

        setContent {
            TodoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    RootNavGraph()
                }
            }
        }
    }
}
