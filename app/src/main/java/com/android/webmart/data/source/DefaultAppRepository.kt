package com.android.webmart.data.source

import com.android.webmart.data.Result
import com.android.webmart.data.model.Banner
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.model.Product
import com.android.webmart.di.LocalAppDataSourceAnnotation
import com.android.webmart.di.RemoteAppDataSourceAnnotation
import com.android.webmart.util.fakedata.getFakeCategoryList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultAppRepository @Inject constructor(
    @LocalAppDataSourceAnnotation private val localAppDataSource: AppDataSource,
    @RemoteAppDataSourceAnnotation private val remoteAppDataSource: AppDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppRepository {

    override fun test(): String {
        return "hello"
    }

    override suspend fun getHomeBanners(): Result<List<Banner>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): Result<List<Category>> {
        return Result.Success(getFakeCategoryList())
    }

    override suspend fun getTopHotelsAndRestaurants(): Result<List<Hotel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopProducts(): Result<List<Product>> {
        TODO("Not yet implemented")
    }
}