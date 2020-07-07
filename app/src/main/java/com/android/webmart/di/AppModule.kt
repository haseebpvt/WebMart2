package com.android.webmart.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.webmart.data.source.AppDataSource
import com.android.webmart.data.source.AppRepository
import com.android.webmart.data.source.DefaultAppRepository
import com.android.webmart.data.source.local.AppDao
import com.android.webmart.data.source.local.AppDatabase
import com.android.webmart.data.source.local.LocalAppDataSource
import com.android.webmart.data.source.remote.RemoteAppDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class LocalAppDataSourceAnnotation

@Qualifier
annotation class RemoteAppDataSourceAnnotation

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppRepository(
        @LocalAppDataSourceAnnotation localAppDataSource: AppDataSource,
        @RemoteAppDataSourceAnnotation remoteAppDataSource: AppDataSource,
        dispatcher: CoroutineDispatcher
    ): AppRepository {
        return DefaultAppRepository(
            localAppDataSource,
            remoteAppDataSource,
            dispatcher
        )
    }

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

    @Singleton
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "AppDatabase.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideAppDao(database: AppDatabase): AppDao {
        return database.appDao()
    }

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("app_preference", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}