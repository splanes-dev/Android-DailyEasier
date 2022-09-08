package com.splanes.dailyeasier.ui.presentation.common.uidata

import androidx.annotation.StringRes
import com.splanes.dailyease.domain.common.datetime.duration.Seconds
import java.util.UUID
import kotlin.time.Duration
import kotlin.time.toDuration

interface LoadableUiData {
    val uuid: UUID
    val timeout: Duration get() = Timeout.toDuration(Duration.Seconds)

    @get:StringRes
    val message: Int? get() = null

    companion object {
        private const val Timeout = 30
    }
}
