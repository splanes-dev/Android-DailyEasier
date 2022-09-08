package com.splanes.dailyeasier.ui.components.core.space.row

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <N : Number> RowScope.Space(height: N) {
    Spacer(modifier = Modifier.width(height.toDouble().dp))
}

@Composable
fun <N : Number> RowScope.Weight(weight: N) {
    Spacer(modifier = Modifier.weight(weight.toFloat().coerceIn(0f..1f)))
}
