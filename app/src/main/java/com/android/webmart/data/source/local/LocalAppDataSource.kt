package com.android.webmart.data.source.local

import android.content.SharedPreferences
import com.android.webmart.data.Result
import com.android.webmart.data.model.Banner
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.model.Product
import com.android.webmart.data.source.AppDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class LocalAppDataSource constructor(
    private val dao: AppDao,
    private val preferences: SharedPreferences,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppDataSource {
    override suspend fun getHomeBanners(): Result<List<Banner>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): Result<List<Category>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopHotelsAndRestaurants(): Result<List<Hotel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopProducts(): Result<List<Product>> {
        TODO("Not yet implemented")
    }
}