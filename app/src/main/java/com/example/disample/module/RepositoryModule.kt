package com.example.disample.module

import com.example.disample.network.ApiClient
import com.example.disample.network.ApiService
import com.example.disample.repository.QiitaRepository
import com.example.disample.repository.QiitaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
//@InstallIn(ActivityComponent::class,NetworkModule::class)
@InstallIn(ActivityComponent::class)
class RepositoryModule {

//    @Singleton
//    @Binds
//    fun bindApiService(
//        qiitaRepositoryImpl: QiitaRepositoryImpl
//    ): QiitaRepository

//    @Provides
//    fun provideApiService(
//        qiitaRepositoryImpl: QiitaRepositoryImpl
//    ): QiitaRepository
//}

    @Provides
    fun provideMainRepository(apiService: ApiService): QiitaRepository {
        return QiitaRepositoryImpl(apiService)
    }
}

//abstract object RepositoryModule {
//    @Provides
//    fun bindApiService(apiService: ApiService):QiitaRepository =  QiitaRepositoryImpl(apiService)
//}