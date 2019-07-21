package io.gold.reduxinkotlinexample

import io.gold.reduxinkotlinexample.state.CounterState
import io.gold.reduxinkotlinexample.state.CounterStateReducer
import io.gold.reduxinkotlinexample.state.entity.DefaultStore

object DI {

    val store = DefaultStore(
        initialState = CounterState(),
        reducer = CounterStateReducer
    )

}