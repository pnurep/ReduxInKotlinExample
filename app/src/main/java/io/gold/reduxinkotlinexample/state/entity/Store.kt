package io.gold.reduxinkotlinexample.state.entity

import io.gold.reduxinkotlinexample.state.Reducer


// State, Action, Reducer 를 최종적으로 바인드 하기위해 사용되는 엔티티
// Store 는 홀로 전체 응용 프로그램 상태에 대한 참조를 저장한다.
// 액션이 액션을 통해 전달 될 때 상태를 변경할 수 있습니다.
// State 가 바뀌었을 때 구독자에게 알려준다.
// 이를 위해 Store 에 액션을 보내는 방법과 구독자를 등록하는 방법이 필요하다.
// 구독자는 최신의 상태로 인젝트 될 수 있는 엔티티 여야 한다.
interface Store<S : State> {
    fun dispatch(action: Action)
    fun add(subscriber: StoreSubscriber<S>): Boolean
}

// 가장 심플한 형태의 구독자는 State 를 받아 Unit 을 리턴하는 함수다.
typealias StoreSubscriber <S> = (S) -> Unit

class DefaultStore<S : State>(
    initialState: S,
    private val reducer: Reducer<S>
) : Store<S> {

    private val subscribers = mutableSetOf<StoreSubscriber<S>>()

    private var state: S = initialState
        set(value) {
            field = value
            subscribers.forEach {
                it.invoke(value)
            }
        }

    override fun dispatch(action: Action) {
        state = reducer(state, action)
    }

    override fun add(subscriber: StoreSubscriber<S>) = subscribers.add(element = subscriber)

}

