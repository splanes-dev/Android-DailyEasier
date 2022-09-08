package com.splanes.dailyeasier.ui.theme.tokens

import androidx.annotation.FontRes
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import com.splanes.dailyeasier.ui.theme.R

internal object TypographyFontFamilyTokens {
    val Quicksand: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(R.font.quicksand, weight = FontWeight.Bold),
            fontOptionLocalOf(R.font.quicksand, weight = FontWeight.Medium),
            fontOptionLocalOf(R.font.quicksand),
            fontOptionLocalOf(R.font.quicksand, weight = FontWeight.Light)
        )
    }
    val YanoneKaffeesatz: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(R.font.yanone_kaffeesatz, weight = FontWeight.Bold),
            fontOptionLocalOf(R.font.yanone_kaffeesatz, weight = FontWeight.Medium),
            fontOptionLocalOf(R.font.yanone_kaffeesatz),
            fontOptionLocalOf(R.font.yanone_kaffeesatz, weight = FontWeight.Light)
        )
    }

    private fun fontOptionLocalOf(@FontRes id: Int, weight: FontWeight = FontWeight.Normal) =
        Font(id, weight = weight, loadingStrategy = FontLoadingStrategy.OptionalLocal)
}
