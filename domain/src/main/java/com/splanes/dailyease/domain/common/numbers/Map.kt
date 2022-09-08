package com.splanes.dailyease.domain.common.numbers

import com.splanes.dailyease.domain.common.logger.crash
import kotlin.reflect.KClass

private val IllegalNumberMapMsg by lazy { "Number type %1\$s cannot be mapped to %2\$s" }

@Suppress("UNCHECKED_CAST")
fun <N1 : Number, N2 : Number> N1.mapTo(target: KClass<N2>) = when (target) {
    Short::class -> toShort() as N2
    Int::class -> toInt() as N2
    Float::class -> toFloat() as N2
    Double::class -> toDouble() as N2
    Long::class -> toLong() as N2
    else -> crash(
        NumberFormatException(IllegalNumberMapMsg.format(this::class.simpleName, target.simpleName))
    )
}
