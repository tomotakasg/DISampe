package com.example.disample.network

import com.example.disample.repository.QiitaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/v2/items")
    suspend fun apiDemo(
        @Query("page") page: Int,
        @Query("par_page") perPage: Int
    ): Response<Array<QiitaResponse>>
}