package com.android.webmart.ui.foodmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.webmart.data.Result
import com.android.webmart.data.model.Food
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.source.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodMenuViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _foodList = MutableLiveData<List<Food>>()
    val foodList: LiveData<List<Food>> = _foodList

    private val _hotel = MutableLiveData<Hotel>()
    val hotel: LiveData<Hotel> = _hotel

    fun loadFood(hotelId: String) {
        viewModelScope.launch {
            when(val result = repository.getFoodListFromHotel("hotel1")) {
                is Result.Success -> _foodList.value = result.data
            }
        }
    }

    fun loadHotel(hotelId: String) {
        viewModelScope.launch {
            when (val result = repository.getHotelById(hotelId)) {
                is Result.Success -> _hotel.value = result.data
            }
        }
    }

    /**
     * Called by Data Binding
     */
    fun addFood(foodId: String) {

    }
}