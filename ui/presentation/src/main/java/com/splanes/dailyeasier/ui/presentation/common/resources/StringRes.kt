package com.splanes.dailyeasier.ui.presentation.common.resources

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontLoadingStrategy
import com.splanes.dailyease.domain.common.logger.crash

inline val @receiver:StringRes Int.stringRes
    @Composable
    get() = stringResource(id = this)

inline val @receiver:DrawableRes Int.painterRes
    @Composable
    get() = painterResource(id = this)

@Composable
inline fun <reified T : Any> resource(crossinline id: () -> Int): T = with(id()) {
    when (T::class) {
        String::class -> this.stringRes as T
        Font::class -> Font(this, loadingStrategy = FontLoadingStrategy.OptionalLocal) as T
        Painter::class -> this.painterRes as T
        else -> crash { "Resource requested of type `${T::class.simpleName}` is not supported." }
    }
}
