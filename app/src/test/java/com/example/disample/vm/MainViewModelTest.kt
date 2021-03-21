package com.example.disample.vm

import com.example.disample.usecase.TopAction
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class MainViewModelTest : Spek({

    // boforeEachがいらなくなった？
    val usecase by memoized {
        mockk<TopAction>()
    }

    val viewModel by memoized {
        MainViewModel(usecase, mockk())
    }

    describe("MainViewModel#request") {

        context("normal pattern") {
            it("success") {
                // coEveryは、suspendに使う
                coEvery {
                    usecase.invoke(mockk(), mockk())
                } returns Unit // 戻りなしはUnitで済ませる
                //実際テストすること
                viewModel.request()
                //想定結果
                coVerify {
                    usecase.invoke(mockk(), mockk())
                }
            }
        }
    }
})