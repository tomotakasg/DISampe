package com.example.disample.module

import com.example.disample.network.ApiClient
import com.example.disample.network.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton   
    fun provideRetrofitClient( // authInterceptor: AuthInterceptork クライアントが増えるたびに@Qualifierを定義
    ): ApiClient = ApiClient()

    @Provides
    @Singleton
    internal fun provideApiService(apiClient: ApiClient
    ) : ApiService =  apiClient.getApiClient().create(ApiService::class.java)
}
