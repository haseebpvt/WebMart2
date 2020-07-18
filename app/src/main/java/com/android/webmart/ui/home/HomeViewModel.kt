package com.android.webmart.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.webmart.data.source.AppRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel(),
    HomeEventListener {

    private val _text = MutableLiveData<String>().apply {
        value = repository.test()
    }
    val text: LiveData<String> = _text

    override fun openCategoryProduct(categoryId: Int) {
        TODO("Not yet implemented")
    }

    override fun openHotelDetails() {
        TODO("Not yet implemented")
    }
}

interface HomeEventListener {
    fun openCategoryProduct(categoryId: Int)
    fun openHotelDetails()
}