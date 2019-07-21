package io.gold.reduxinkotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.gold.reduxinkotlinexample.state.CounterActions
import io.gold.reduxinkotlinexample.state.CounterState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 이 설정을 사용하면 Redux가 선호하는 단방향 데이터 흐름을 명확하게 확인할 수 있다.
    // Store에 Action을 발송하여 상태에 영향을 미치려는 모든 변경 사항이 적용된다.
    // 화면에서 렌더링하려는 모든 항목은 스토어에서 구독자를 통해 상태가 변경되었음을 알려 주는 경우에만 발생한다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DI.store.add {
            counter_text_view.text = "${it.value}"
        }

        //dispatch CounterActions Init
        DI.store.dispatch(
            action = CounterActions.Init
        )

        decrement_button.setOnClickListener {
            // dispatch CounterActions.Decrement
            DI.store.dispatch(
                action = CounterActions.Decrement
            )
        }

        increment_button.setOnClickListener {
            // dispatch CounterActions.Increment
            DI.store.dispatch(
                action = CounterActions.Increment
            )
        }

    }

}
