package com.splanes.dailyeasier.ui.presentation.feature.auth

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.splanes.dailyeasier.ui.components.core.space.column.Spacer
import com.splanes.dailyeasier.ui.components.core.space.column.Weight
import com.splanes.dailyeasier.ui.presentation.R.string as RStrings
import com.splanes.dailyeasier.ui.presentation.common.activity.ThemeContentActivity
import com.splanes.dailyeasier.ui.presentation.common.anim.visibility.FadeVisibility
import com.splanes.dailyeasier.ui.presentation.feature.auth.ui.AuthFormComponent
import com.splanes.dailyeasier.ui.presentation.feature.auth.ui.AuthTitle
import com.splanes.dailyeasier.ui.presentation.feature.auth.ui.AuthTypeSwitchButton
import com.splanes.dailyeasier.ui.presentation.feature.auth.ui.AuthUiTokens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ThemeContentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Content() {
        val viewModel: AuthViewModel = hiltViewModel()
        val authUiState by viewModel.uiStateValue
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(AuthUiTokens.ContentPadding)
        ) {
            AnimatedContent(
                targetState = authUiState,
                transitionSpec = ,
                contentAlignment = Alignment.TopCenter
            ) {stateValue ->
                when (stateValue) {
                    AuthUiStateValue.Undefined -> null
                    is AuthUiStateValue.SignIn -> RStrings.sign_in_subtitle
                    is AuthUiStateValue.SignUp -> RStrings.sign_up_subtitle
                    is AuthUiStateValue.Error -> TODO()
                    is AuthUiStateValue.Loading -> TODO()
                }
            }

            Weight(weight = .25)
            val titleRes: Int? =
                FadeVisibility(visible = titleRes != null) {
                    titleRes?.let { AuthTitle(textRes = titleRes) }
                }
            Spacer(height = 16)
            AuthFormComponent(viewModel)
            Weight()
            AuthTypeSwitchButton(
                textRes = 0,
                onClick = viewModel::onSwitchAuthValue
            )
        }
    }
}
