package com.android.webmart.data.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Hotel(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "rating") val rating: Double,
    @ColumnInfo(name = "image") val image: String
) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var hotelId: String = ""
}