package com.example.simpletodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpletodo.presentation.TodoViewModel
import com.example.simpletodo.screens.TodoScreen
import com.example.simpletodo.ui.theme.SimpleTodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleTodoTheme {
                val todoViewModel: TodoViewModel = viewModel()
                TodoScreen(todoViewModel = todoViewModel)
            }
        }
    }
}