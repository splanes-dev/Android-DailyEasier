package com.splanes.dailyeasier.ui.presentation.common.distances.rules

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class Dps8Based {

    @Test
    fun `given 8-based int, when rule is applied, then nothing happens`() {
        val integer = 16

        val result = integer.to8Factor()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(integer)
    }

    @Test
    fun `given 8-based decimal num, when rule is applied, then nothing happens`() {
        val decimalNum = 16.5f

        val result = decimalNum.to8Factor()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(decimalNum)
    }

    @Test
    fun `given NON 8-based int, when rule is applied, then is rounded to next 8 factor`() {
        val integer = 5
        val expected = 8

        val result = integer.to8Factor()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `given NON 8-based int, when rule is applied rounding down, then is rounded to prior 8 factor`() {
        val integer = 9
        val expected = 8

        val result = integer.to8Factor(roundToUp = false)

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `given NON 8-based decimal num, when rule is applied, then nothing happens`() {
        val decimalNum = 13.5f
        val expected = 16.5f

        val result = decimalNum.to8Factor()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo(expected)
    }
}
