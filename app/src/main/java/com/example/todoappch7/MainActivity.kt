package com.example.todoappch7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.todoappch7.ui.screens.TodoScreen
import com.example.todoappch7.ui.theme.TodoAppCh7Theme

class MainActivity : ComponentActivity() {
    // viewModels() it creates the viewModel and keeps it alive during the configuration changes
    private val viewModel: TodoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppCh7Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TodoScreen(viewModel)
                }
            }
        }
    }
}