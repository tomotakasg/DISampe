package com.example.disample.repository

import com.example.disample.network.ApiService
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import retrofit2.Response
import kotlin.test.assertTrue

class QiitaRepositoryTest : Spek({

    // 便利すぎないか・・・これ
    val response by memoized {
        mockk<Response<Array<QiitaResponse>>>(relaxed = true)
    }

    val qiitaResponse = arrayOf(QiitaResponse("test", "test", null))

    val apiService by memoized {
        mockk<ApiService>()
    }

    val baseRepository by memoized {
        mockk<BaseRepository>()
    }

    val qiitaRepository by memoized {
        QiitaRepositoryImpl(apiService)
    }

    describe("QiitaRepositoryImpl#request") {
        context("normal pattern") {
            it("success") {
                coEvery {
                    apiService.apiDemo(any(), any())
                } returns response

                // BaseRepository#apiOutputの条件に入るように偽装していく
                every {
                    response.isSuccessful
                } returns true

                every {
                    response.body()
                } returns qiitaResponse

                //本当にapiを投げる形にして、確認する。本当は個々にレスポンスパラメータ見て欲しい
                runBlocking {
                    val result = qiitaRepository.request(0, 0)
                    //想定結果
                    assertTrue { result is QiitaResponse }
                }
            }

            it("error return null") {
                coEvery {
                    apiService.apiDemo(any(), any())
                } returns response
                runBlocking {
                    val result = qiitaRepository.request(0, 0)

                    //想定結果
                    assertTrue { result == null }
                }
            }
        }
    }
})