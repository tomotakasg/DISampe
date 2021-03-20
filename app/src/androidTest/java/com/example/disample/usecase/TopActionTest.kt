package com.example.disample.usecase

import com.example.disample.repository.QiitaRepository
import com.example.disample.repository.QiitaResponse
import com.example.disample.repository.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class TopActionTest : Spek({
    val repository by memoized {
        mockk<QiitaRepository>()
    }

    val topActionUseCases by memoized {
        TopAction(repository)
    }


    describe("TopAction#run") {
        context("normal pattern") {
            it("success") {
                coEvery {
                    repository.request(any(), any())
                } returns QiitaResponse("abc", "", mockk<User>())

                // suspendを実行するいい方法がわからないので、runBlockingで対応してみる
                runBlocking {
                    val result = topActionUseCases.run()
                    assertEquals(result?.url, "abc")
                }

                coVerify {
                    repository.request(any(), any())
                }
            }
        }
    }
})