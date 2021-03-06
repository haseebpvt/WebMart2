package com.android.webmart.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.webmart.data.Result
import com.android.webmart.data.model.Category
import com.android.webmart.data.model.Hotel
import com.android.webmart.data.source.AppRepository
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScoped
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = repository.test()
    }
    val text: LiveData<String> = _text

    private val _categoryList = MutableLiveData<List<Category>>().apply {
        viewModelScope.launch {
            when(val result = repository.getCategories()) {
                is Result.Success -> value = result.data
            }
        }
    }
    val categoryList: LiveData<List<Category>> = _categoryList

    private val _hotelList = MutableLiveData<List<Hotel>>().apply {
        viewModelScope.launch {
            when(val result = repository.getTopHotelsAndRestaurants()) {
                is Result.Success -> value = result.data
            }
        }
    }
    val hotelList: LiveData<List<Hotel>> = _hotelList

    private val _actionOpenHotel = MutableLiveData<Unit>()
    val actionOpenHotel: LiveData<Unit> = _actionOpenHotel

    /**
     * Called by Data Binding
     */
    fun openCategory(id: Int) {

    }

    /**
     * Called by Data Binding
     */
    fun openHotel(hotelId: String) {
        _actionOpenHotel.postValue(Unit)
    }
}