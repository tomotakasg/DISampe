package com.example.disample.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

/**
 * ActivityRetainedScopeはActivityのViewModelScopeだから
 * 現状FragmentのviewModelは想定していないはず
 * https://developer.android.com/training/dependency-injection/hilt-android?hl=ja
 * 公式のコンポーネントの階層を信じたいが・・
 *
 * 現状 ActivityRetainedComponentでエラーが出てviewModel DIやめる
 */
//
//@Module
//@InstallIn(ActivityRetainedScoped::class)
//class ViewModelModule {
//}
