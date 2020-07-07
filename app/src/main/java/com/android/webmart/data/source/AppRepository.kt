package com.android.webmart.data.source

import com.android.webmart.data.Result
import com.android.webmart.data.model.Banner
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.model.Product

interface AppRepository {

    /**
     * Get main banner
     * Primary use case in Home screen
     */
    suspend fun getHomeBanners(): Result<List<Banner>>

    /**
     * Get all product categories
     * Primary use case in Home screen
     */
    suspend fun getCategories(): Result<List<Category>>

    /**
     * Get top hotels and restaurants
     * Primary use case in Home screen
     */
    suspend fun getTopHotelsAndRestaurants(): Result<List<Hotel>>

    /**
     * Get top products
     * Primary use case in Home screen
     */
    suspend fun getTopProducts(): Result<List<Product>>
}