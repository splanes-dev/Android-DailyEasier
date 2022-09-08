package com.splanes.dailyeasier.ui.presentation.common.uidata

import androidx.annotation.StringRes
import java.util.UUID

interface ErrorUiData {
    val uuid: UUID
    val cause: Throwable? get() = null

    @get:StringRes
    val message: Int? get() = null

    val behavior: ErrorHandleBehavior get() = ErrorHandleBehavior.Hide
}

enum class ErrorHandleBehavior {
    Fatal,
    Hide,
    CustomUi
}
