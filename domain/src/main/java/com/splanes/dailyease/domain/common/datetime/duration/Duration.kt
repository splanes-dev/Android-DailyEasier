package com.splanes.dailyease.domain.common.datetime.duration

import kotlin.time.Duration
import kotlin.time.DurationUnit

val Duration.Companion.Nano get() = DurationUnit.NANOSECONDS
val Duration.Companion.Micro get() = DurationUnit.MICROSECONDS
val Duration.Companion.Millis get() = DurationUnit.MILLISECONDS
val Duration.Companion.Seconds get() = DurationUnit.SECONDS
val Duration.Companion.Minutes get() = DurationUnit.MINUTES
val Duration.Companion.Hours get() = DurationUnit.HOURS
val Duration.Companion.Days get() = DurationUnit.DAYS
