package com.splanes.dailyeasier.ui.presentation.feature.auth.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.splanes.dailyeasier.ui.presentation.feature.auth.AuthViewModel

@Composable
fun AuthFormComponent(
    viewModel: AuthViewModel = hiltViewModel()
) {
    val data = viewModel.data
}
