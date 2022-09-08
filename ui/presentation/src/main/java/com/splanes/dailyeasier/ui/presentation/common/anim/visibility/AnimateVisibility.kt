package com.splanes.dailyeasier.ui.presentation.common.anim.visibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.time.Duration

@Composable
fun FadeVisibility(
    visible: Boolean,
    modifier: Modifier = Modifier,
    durationIn: Duration = AnimatedVisibilityTokens.FadeInVisibilityDuration,
    durationOut: Duration = AnimatedVisibilityTokens.FadeOutVisibilityDuration,
    content: @Composable() AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn(tween(durationIn.inWholeMilliseconds.toInt())),
        exit = fadeOut(tween(durationOut.inWholeMilliseconds.toInt())),
        label = AnimatedVisibilityTokens.FadeVisibilityLabel,
        content = content
    )
}
