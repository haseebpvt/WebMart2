package com.android.webmart.di

import com.android.webmart.data.source.AppRepository
import com.android.webmart.data.source.DefaultAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun bindRepository(repo: DefaultAppRepository): AppRepository
}