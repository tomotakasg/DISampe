package com.example.disample.module

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @AppHash
    @Provides
    fun provideHash(): String {
        return hashCode().toString()
    }
}

/**
 * daggerに識別させるために定義しておく
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AppHash

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ActivityHash

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class FragmentHash
