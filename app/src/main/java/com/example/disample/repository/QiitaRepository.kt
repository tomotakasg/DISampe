package com.example.disample.repository

interface QiitaRepository {
    suspend fun request(page: Int, perPage: Int): QiitaResponse?
}

data class QiitaResponse(
    val url: String?,
    val title: String?,
    val user: User?
)

data class User(
    val id: String?
)