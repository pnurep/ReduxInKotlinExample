package io.gold.reduxinkotlinexample.state

import io.gold.reduxinkotlinexample.state.entity.State

data class CounterState(
    val value: Int = 0
) : State