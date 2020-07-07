package com.android.webmart.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.webmart.data.source.AppRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = repository.test()
    }
    val text: LiveData<String> = _text
}