package com.splanes.dailyeasier.ui.presentation.feature.auth.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.dailyeasier.ui.components.core.space.column.Weight
import com.splanes.dailyeasier.ui.presentation.common.resources.stringRes
import com.splanes.dailyeasier.ui.theme.Theme
import com.splanes.dailyeasier.ui.presentation.R.string as RString

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AuthTitle(@StringRes textRes: Int) {
    AnimatedContent(
        targetState = textRes,
        contentAlignment = Alignment.Center
    ) { subtitle ->
        RString.sign_in_subtitle
        Text(
            text = RString.app_name_pretty.stringRes,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = subtitle.stringRes,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
@Preview
private fun AuthTitlePreview() {
    Theme {
        var isSignIn: Boolean by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Weight(.5)
            AuthTitle(textRes = if (isSignIn) RString.sign_in_subtitle else RString.sign_up_subtitle)
            Weight()
            Button(onClick = { isSignIn = !isSignIn }) { Text("Change") }
            Weight(.5)
        }
    }
}
