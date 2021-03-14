package com.example.disample.repository

import com.example.disample.network.ApiService
import com.example.disample.network.NetworkResult
import timber.log.Timber
import javax.inject.Inject

class QiitaRepositoryImpl @Inject constructor (private val apiService: ApiService) :QiitaRepository,BaseRepository(){
    override suspend fun request(page: Int, perPage: Int): QiitaResponse? {
        val output = apiOutput(
            call = { apiService.apiDemo(page, perPage) },
            error = "calling fetchUserList failed"
        )

        when (output) {
            is NetworkResult.Success ->
                return output.data[0]//なんでもいいからとりあえず
            is NetworkResult.Error ->
                Timber.d("error" + output.exception)
        }
        return null
    }


}

