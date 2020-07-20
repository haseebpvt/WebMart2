package com.android.webmart.data.model

import kotlin.math.roundToInt

data class Food(
    val title: String,
    val image: String,
    val actualPrice: Double,
    val offerPrice: Double,
    val orderItemLimit: Int,
    val available: Boolean,
    val hotelId: String
) {

    var foodId: String = ""
    var offerPercent: Int = 0

    // TODO(Do proper calculation)
    fun getOfferText(): String {
        val percent: Double = (actualPrice/100) * offerPrice
        return "${percent.roundToInt()} Offer"
    }
}