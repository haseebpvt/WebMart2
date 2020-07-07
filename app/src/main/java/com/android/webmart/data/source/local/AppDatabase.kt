package com.android.webmart.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.webmart.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}