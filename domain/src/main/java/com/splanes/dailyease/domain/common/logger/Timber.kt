package com.splanes.dailyease.domain.common.logger

import timber.log.Timber

val Log: Timber.Forest by lazy {
    if (Timber.treeCount == 0) Timber.plant(timberTreeByBuildVariant())
    Timber
}

fun Timber.Forest.verbose(tag: String? = null, msg: () -> String?) {
    Log.apply { if (tag != null) tag(tag) }.v(msg())
}

fun Timber.Forest.crash(error: Throwable): Nothing {
    Log.e(error)
    throw error
}

fun Timber.Forest.crash(msg: () -> String): Nothing {
    Log.crash(RuntimeException(msg()))
}

fun crash(error: Throwable): Nothing {
    Log.crash(error)
}

fun crash(msg: () -> String): Nothing {
    Log.crash(msg)
}

internal fun timberTreeByBuildVariant(): Timber.Tree {
    return Timber.DebugTree()
}
