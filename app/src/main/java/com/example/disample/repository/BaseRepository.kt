package com.example.disample.repository

import com.example.disample.network.NetworkResult
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> apiOutput(call: suspend () -> Response<T>, error: String): NetworkResult<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            NetworkResult.Success(response.body()!!)
        else
            NetworkResult.Error(IOException(error))
    }
}