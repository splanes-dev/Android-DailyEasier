package com.splanes.dailyeasier.ui.presentation.common.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.splanes.dailyease.domain.common.logger.Log
import com.splanes.dailyease.domain.common.logger.verbose

interface LifecycleLogger {
    fun lifecycleOwner(owner: LifecycleOwner)
}

class LifecycleLoggerImpl : LifecycleLogger, LifecycleEventObserver {
    override fun lifecycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.verbose { "Lifecycle event - name: `${event.name}`, targetState: `${event.targetState}`" }
    }
}
