package com.elahee.triviaapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.elahee.triviaapp.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionViewModel= hiltViewModel()){
    Questions(viewModel = viewModel)
}
