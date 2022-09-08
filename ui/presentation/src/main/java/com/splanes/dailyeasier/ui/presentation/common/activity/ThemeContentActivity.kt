package com.splanes.dailyeasier.ui.presentation.common.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.splanes.dailyeasier.ui.presentation.common.lifecycle.LifecycleLogger
import com.splanes.dailyeasier.ui.presentation.common.lifecycle.LifecycleLoggerImpl
import com.splanes.dailyeasier.ui.theme.Theme

abstract class ThemeContentActivity :
    ComponentActivity(),
    LifecycleLogger by LifecycleLoggerImpl() {

    protected open val darkTheme
        @Composable
        get() = isSystemInDarkTheme()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleOwner(this)
        setContent { Theme(darkTheme) { Content() } }
    }

    @Composable
    protected open fun Content() {
        // Nothing to do here
    }
}
