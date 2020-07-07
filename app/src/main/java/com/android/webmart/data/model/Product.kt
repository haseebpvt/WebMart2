package com.android.webmart.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "seller") val seller: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "image") val image: String
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "price_text")
    val priceText: String = "₹$price"

    @ColumnInfo(name = "product_id")
    var productId: String = ""
}