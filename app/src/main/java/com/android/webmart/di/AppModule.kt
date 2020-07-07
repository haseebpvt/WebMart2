package com.android.webmart.di

import android.content.SharedPreferences
import com.android.webmart.data.source.AppDataSource
import com.android.webmart.data.source.local.AppDao
import com.android.webmart.data.source.local.LocalAppDataSource
import com.android.webmart.data.source.remote.RemoteAppDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class LocalAppDataSourceAnnotation

@Qualifier
annotation class RemoteAppDataSourceAnnotation

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @LocalAppDataSourceAnnotation
    @Singleton
    @Provides
    fun provideLocalAppDataSource(
        dao: AppDao,
        preferences: SharedPreferences,
        dispatcher: CoroutineDispatcher
    ): AppDataSource {
        return LocalAppDataSource(dao, preferences, dispatcher)
    }

    @RemoteAppDataSourceAnnotation
    @Singleton
    @Provides
    fun provideRemoteAppDataSource(
        firestore: FirebaseFirestore,
        dispatcher: CoroutineDispatcher
    ): AppDataSource {
        return RemoteAppDataSource(firestore, dispatcher)
    }
}