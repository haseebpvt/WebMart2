package com.android.webmart.di

import android.content.SharedPreferences
import com.android.webmart.data.source.AppDataSource
import com.android.webmart.data.source.local.AppDao
import com.android.webmart.data.source.local.LocalAppDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideLocalAppDataSource(
        dao: AppDao,
        preferences: SharedPreferences,
        dispatcher: CoroutineDispatcher
    ): AppDataSource {
        return LocalAppDataSource(dao, preferences, dispatcher)
    }
}