package com.example.trviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.trviaapp.component.Questions

@Composable
fun TriviaHomeApps(viewModel: QuestionViewModel = hiltViewModel()) {
    Questions(viewModel)

}