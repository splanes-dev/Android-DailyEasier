package com.splanes.dailyease.domain.common.uuid

import android.os.Parcelable
import com.splanes.dailyease.domain.common.datetime.timestamp.currentMillis
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Parcelize
@JvmInline
value class Uuid(
    val value: Long = currentMillis()
) : Parcelable {
    companion object
}

fun Uuid.Companion.random() = Uuid()

fun UUID.stringify() = toString().replace("-", "")
