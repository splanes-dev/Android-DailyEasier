package com.splanes.dailyeasier.ui.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.splanes.dailyeasier.ui.presentation.common.lifecycle.LifecycleLogger
import com.splanes.dailyeasier.ui.presentation.common.lifecycle.LifecycleLoggerImpl
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class ComponentViewModel :
    ViewModel(),
    CoroutineScope,
    LifecycleLogger by LifecycleLoggerImpl() {

    private val supervisorJob = SupervisorJob()
    val coroutineStart = CoroutineStart.DEFAULT
    val ioContext: CoroutineContext = Dispatchers.IO + supervisorJob
    override val coroutineContext: CoroutineContext = Dispatchers.Main.immediate + supervisorJob

    override fun onCleared() {
        super.onCleared()
        supervisorJob.cancelAll()
    }

    private fun CompletableJob.cancelAll() =
        takeIf { supervisor -> supervisor.isActive }?.run {
            cancelChildren()
            cancel()
        }

    protected suspend inline fun <T> Flow<T>.handle(crossinline block: (data: T) -> Unit) =
        collect { data -> withContext(coroutineContext) { block(data) } }

}

fun ComponentViewModel.launchOnMain(
    context: CoroutineContext = coroutineContext,
    start: CoroutineStart = coroutineStart,
    block: suspend CoroutineScope.() -> Unit
) =
    viewModelScope.launch(context, start, block)

fun ComponentViewModel.launchOnIO(
    context: CoroutineContext = ioContext,
    start: CoroutineStart = coroutineStart,
    block: suspend CoroutineScope.() -> Unit
) =
    viewModelScope.launch(context, start, block)
