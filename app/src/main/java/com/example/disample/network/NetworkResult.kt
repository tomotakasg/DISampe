package com.example.disample.network

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error<out T : Any>(val exception: Exception) : NetworkResult<T>()
    object InProgress : NetworkResult<Nothing>()
}