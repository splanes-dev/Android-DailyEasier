package com.splanes.dailyeasier.ui.theme.typographies

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.splanes.dailyeasier.ui.theme.tokens.TypographyFontFamilyTokens
import com.splanes.dailyeasier.ui.theme.tokens.TypographyParamsTokens

val Typography by lazy {
    Typography(
        displayLarge = with(TypographyParamsTokens.DisplayLarge) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        displayMedium = with(TypographyParamsTokens.DisplayMedium) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        displaySmall = with(TypographyParamsTokens.DisplaySmall) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        headlineLarge = with(TypographyParamsTokens.HeadlineLarge) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        headlineMedium = with(TypographyParamsTokens.HeadlineMedium) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        headlineSmall = with(TypographyParamsTokens.HeadlineSmall) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        titleLarge = with(TypographyParamsTokens.TitleLarge) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        titleMedium = with(TypographyParamsTokens.TitleMedium) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.YanoneKaffeesatz,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        titleSmall = with(TypographyParamsTokens.TitleSmall) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.YanoneKaffeesatz,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        bodyLarge = with(TypographyParamsTokens.BodyLarge) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.YanoneKaffeesatz,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        bodyMedium = with(TypographyParamsTokens.BodyMedium) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.YanoneKaffeesatz,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        bodySmall = with(TypographyParamsTokens.BodySmall) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.YanoneKaffeesatz,
                fontWeight = FontWeight.Light,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        labelLarge = with(TypographyParamsTokens.LabelLarge) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        labelMedium = with(TypographyParamsTokens.LabelMedium) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        },
        labelSmall = with(TypographyParamsTokens.LabelSmall) {
            TextStyle(
                fontFamily = TypographyFontFamilyTokens.Quicksand,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing.sp,
                lineHeight = lineHeight.sp,
                fontSize = fontSize.sp
            )
        }
    )
}
