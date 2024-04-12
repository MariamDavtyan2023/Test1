package com.example.test1.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface Repository {
    fun getProducts() : Flow<List<String>>
}

class TestRepository : Repository {

    override
    fun getProducts(): Flow<List<String>> = flow {
        emit(listOf("Product1", "Product2"))
    }
}