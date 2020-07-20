package com.android.webmart.util.fakedata

import com.android.webmart.data.model.Hotel

fun getFakeHotelList(): List<Hotel> {
    val hotel1 =
        "https://content3.jdmagicbox.com/comp/thiruvananthapuram/f8/0471px471.x471.171128021049.u5f8/catalogue/kerala-hotel-kochuveli-thiruvananthapuram-kerala-restaurants-89i62.jpg"
    val hotel2 = "https://www.keralatourpackages.com/img/5star-kerala-tour1.jpg"
    val hotel3 =
        "https://english.mathrubhumi.com/polopoly_fs/1.4645706.1585233764!/image/image.jpg_gen/derivatives/landscape_894_577/image.jpg"

    val one = Hotel("Hotel 1", "Restaurant", 4.5, hotel1)
    one.hotelId = "hotel1"
    val two = Hotel("Hotel 2", "Restaurant", 4.5, hotel2)
    two.hotelId = "hotel2"
    val three = Hotel("Hotel 3", "Hotel", 4.5, hotel3)
    three.hotelId = "hotel3"

    return listOf(
        one, two, three
    )
}

fun getFakeHotel(): Hotel {
    val hotel1 =
        "https://content3.jdmagicbox.com/comp/thiruvananthapuram/f8/0471px471.x471.171128021049.u5f8/catalogue/kerala-hotel-kochuveli-thiruvananthapuram-kerala-restaurants-89i62.jpg"
    val one = Hotel("Hotel 1", "Restaurant", 4.5, hotel1)
    return one
}