package com.example.disample.usecase

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 参考
 * https://star-zero.medium.com/kotlin%E3%81%AEinvoke-operator-5fe733e75738
 */
abstract class BaseUseCase<Type> where Type:Any {
    abstract suspend fun run():Type?

    suspend inline operator fun invoke(scope:CoroutineScope,data:MutableLiveData<Type>) {
        val result = withContext(context = scope.coroutineContext + Dispatchers.IO)        {
            run()
        }
        data.postValue(result)
    }

    suspend inline operator fun invoke(scope: CoroutineScope):Type?{
        return withContext(context = scope.coroutineContext + Dispatchers.IO)  {
            run()
        }
    }
}