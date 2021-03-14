package com.example.disample.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @ActivityHash
    @Provides
    fun provideHash(): String {
        // fragmentModuleなどから、別ハッシュ取れることを確認するためだけのもの
        return hashCode().toString()
    }

    //hiltになると、ここに作成したactivityを紐付け内で、本体にアノテーションで対応みたい
}