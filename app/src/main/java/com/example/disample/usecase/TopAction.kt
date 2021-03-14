package com.example.disample.usecase

import com.example.disample.repository.QiitaRepository
import com.example.disample.repository.QiitaResponse
import javax.inject.Inject

class TopAction @Inject constructor(private val qiitaRepository: QiitaRepository):
    BaseUseCase<QiitaResponse>(){
    override suspend fun run(): QiitaResponse? {
        // リクエストパラメータは適当で
        return qiitaRepository.request(1,1)
    }
}