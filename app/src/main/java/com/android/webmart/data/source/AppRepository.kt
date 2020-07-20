package com.android.webmart.data.source

import com.android.webmart.data.Result
import com.android.webmart.data.model.*

interface AppRepository {

    /**
     * Test method which simply return the String 'hello'
     */
    fun test(): String

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

    /**
     * Get all food from given hotel ID
     */
    suspend fun getFoodListFromHotel(hotelId: String): Result<List<Food>>
}