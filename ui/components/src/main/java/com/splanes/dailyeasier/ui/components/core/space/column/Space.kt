package com.splanes.dailyeasier.ui.components.core.space.column

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <N : Number> ColumnScope.Spacer(height: N) {
    Spacer(modifier = Modifier.height(height.toDouble().dp))
}

@Composable
fun ColumnScope.Weight(weight: Double = 1.0) {
    Spacer(modifier = Modifier.weight(weight.toFloat().coerceIn(0f..1f)))
}
