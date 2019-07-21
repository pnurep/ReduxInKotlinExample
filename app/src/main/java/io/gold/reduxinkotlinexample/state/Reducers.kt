package io.gold.reduxinkotlinexample.state

import io.gold.reduxinkotlinexample.state.entity.Action

// State 와 Action 은 어떻게 해서든 연결이 될 필요가 있고,
// 그 연결하는 방법은 Reducer 를 통해서 한다.
// Reducer 는 단순히 예전의 상태와 행동을 받아들이고 새로운 상태를 되돌려주는 순수함수이다.
// 이 방법만이 시스템 상태를 변경하여 앱의 모든 비즈니스 논리를 활성화할 수 있는 유일한 방법이다.
// 이 규칙에는 예외가 없어야 한다.
typealias Reducer <S> = (S, Action) -> S

// 우리는 우리의 카운터액티비티와 관련된 모든 비즈니스 논리와 모든 상태 변이를 우리가 자유 기능으로 구현한 전문화된 실체로 옮겼다.
val CounterStateReducer: Reducer<CounterState> = { old, action ->
    when (action) {
        is CounterActions.Init -> CounterState()
        is CounterActions.Increment -> old.copy(value = old.value + 1)
        is CounterActions.Decrement -> old.copy(value = old.value - 1)
        else -> old
    }
}