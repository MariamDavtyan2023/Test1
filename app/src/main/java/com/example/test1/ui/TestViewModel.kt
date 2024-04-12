package com.example.test1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test1.data.TestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {

    private val repo = TestRepository()

    val products: Flow<List<ProductModel>> = getProductsModel()

    private fun getProductsModel() : Flow<List<ProductModel>> {
        val list = mutableListOf<ProductModel>()
        viewModelScope.launch {
            repo.getProducts()
                .collect{
                    list.addAll(ProductModel.mapListToProductModelList(it))
                }
        }
        return flowOf(list)
    }


}