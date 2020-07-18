package com.android.webmart.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.webmart.data.Result
import com.android.webmart.data.model.Category
import com.android.webmart.data.source.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    /**
     * Called by Data Binding
     */
    fun openCategory(id: Int) {

    }
}