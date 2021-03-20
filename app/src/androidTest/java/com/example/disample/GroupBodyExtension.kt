package com.example.disample


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.spekframework.spek2.dsl.GroupBody

/**
 * 想定では、viewModelのテストに必要そうだったが、必要なくなったため、削除可能
 * never use
 */
fun GroupBody.applyTestDispatchers() {

    beforeEachTest {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }
    afterEachTest {
        Dispatchers.resetMain()
    }
}
