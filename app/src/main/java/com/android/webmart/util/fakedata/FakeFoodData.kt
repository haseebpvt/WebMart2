package com.android.webmart.util.fakedata

import com.android.webmart.data.model.Food

fun getFakeFoodList(): List<Food> {
    val image = "https://pluspng.com/img-png/food-png-food-salad-image-2962-428.png"
    val hotelId = "hotel1"

    return listOf(
        Food("Chicken biriyani", image, 100.0, 50.0, 10, true, hotelId),
        Food("Chapathi", image, 100.0, 50.0, 10, true, hotelId),
        Food("Sandwich", image, 100.0, 50.0, 10, true, hotelId),
        Food("Shawarma", image, 100.0, 50.0, 10, true, hotelId),
        Food("Porata", image, 100.0, 50.0, 10, true, hotelId),
        Food("Vegitable biriyani", image, 100.0, 50.0, 10, true, hotelId),
        Food("Egg curry", image, 100.0, 50.0, 10, true, hotelId),
        Food("Barbique", image, 100.0, 50.0, 10, true, hotelId),
        Food("Rice", image, 100.0, 50.0, 10, true, hotelId),
        Food("Plate shawarma", image, 100.0, 50.0, 10, true, hotelId)
    )
}