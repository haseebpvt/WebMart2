package com.android.webmart.util.fakedata

import com.android.webmart.data.model.Category

private val image = "https://www.pngitem.com/pimgs/m/65-656708_transparent-background-stationery-png-png-download.png"


fun getFakeCategoryList(): List<Category> {
    val image = ""
    val food = "https://pluspng.com/img-png/food-png-food-salad-image-2962-428.png"
    val grocery =
        "https://www.kindpng.com/picc/m/241-2413673_grocery-background-png-transparent-background-groceries-transparent-png.png"
    val fruits =
        "https://pluspng.com/img-png/fruits-and-vegetables-png-hd-vegetable-png-transparent-image-1799.png"
    val meat =
        "https://www.pngkit.com/png/detail/67-676856_fish-and-meat-png-transparent-fish-and-meat.png"
    val stationary =
        "https://www.pngitem.com/pimgs/m/65-656708_transparent-background-stationery-png-png-download.png"
    val dress =
        "https://purepng.com/public/uploads/large/purepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326975ia8xr.png"

    return listOf(
        Category(0, "Food & Restaurant", food),
        Category(1, "Grocery & Essentials", grocery),
        Category(2, "Fruits & Vegetables", fruits),
        Category(3, "Meat & Fish", meat),
        Category(4, "Stationary Items", stationary),
        Category(5, "Dress & Fashion", dress)
    )
}