package com.example.test1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test1.data.TestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class TestViewModel(private val repo: TestRepository) : ViewModel() {


    private val _productStateFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val productStateFlow: StateFlow<List<String>>
        get() = _productStateFlow

    fun getProducts() {
        viewModelScope.launch {
            repo.getProducts()
                .catch {
                    // Handle error cases
                }
                .collectLatest {
                    _productStateFlow.value = it
                }
        }
    }


}