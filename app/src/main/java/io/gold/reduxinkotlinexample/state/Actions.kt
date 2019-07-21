package io.gold.reduxinkotlinexample.state

import io.gold.reduxinkotlinexample.state.entity.Action

sealed class CounterActions : Action {
    object Init : CounterActions()
    object Increment : CounterActions()
    object Decrement : CounterActions()
}