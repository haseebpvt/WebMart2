package com.android.webmart.data.source

import com.android.webmart.data.Result
import com.android.webmart.data.model.Banner
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.model.Product
import com.android.webmart.di.LocalAppDataSourceAnnotation
import com.android.webmart.di.RemoteAppDataSourceAnnotation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultAppRepository constructor(
    @LocalAppDataSourceAnnotation private val localAppDataSource: AppDataSource,
    @RemoteAppDataSourceAnnotation private val remoteAppDataSource: AppDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppRepository {
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