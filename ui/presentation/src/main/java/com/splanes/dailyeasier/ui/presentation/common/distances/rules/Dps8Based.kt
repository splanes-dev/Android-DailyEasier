package com.splanes.dailyeasier.ui.presentation.common.distances.rules

import com.splanes.dailyease.domain.common.numbers.mapTo
import kotlin.math.absoluteValue

private const val FACTOR = 8

fun <N : Number> N.to8Factor(roundToUp: Boolean = true): N {
    var n = toInt().absoluteValue
    val dec = toDouble().absoluteValue - toInt().absoluteValue
    return if (n % FACTOR == 0) {
        this
    } else {
        while (n % FACTOR != 0 && (n > FACTOR || FACTOR % n != 0)) {
            if (roundToUp) n++ else n--
        }
        if (dec > 0) {
            n + dec
        } else {
            n
        }.mapTo(this::class)
    }
}
