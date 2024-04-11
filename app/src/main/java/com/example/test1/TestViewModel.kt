package com.example.test1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    private val repo = TestRepository()

    private val _products = MutableLiveData<List<String>>()
    val products : LiveData<List<String>>
        get() = _products

    fun getProducts() {
        viewModelScope.launch {
            repo.getProducts()
                .collect {
                    _products.value = it
                }
        }
    }
}