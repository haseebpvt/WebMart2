package com.android.webmart.ui.foodmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.webmart.data.Result
import com.android.webmart.data.model.Food
import com.android.webmart.data.source.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodMenuViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _foodList = MutableLiveData<List<Food>>().apply {
        viewModelScope.launch {
            when(val result = repository.getFoodListFromHotel("hotel1")) {
                is Result.Success -> value = result.data
            }
        }
    }
    val foodList: LiveData<List<Food>> = _foodList

    /**
     * Called by Data Binding
     */
    fun addFood(foodId: String) {

    }
}