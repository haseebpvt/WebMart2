package com.android.webmart.data.source.remote

import com.android.webmart.data.Result
import com.android.webmart.data.model.*
import com.android.webmart.data.source.AppDataSource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RemoteAppDataSource @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
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

    override suspend fun getFoodListFromHotel(hotelId: String): Result<List<Food>> {
        TODO("Not yet implemented")
    }
}