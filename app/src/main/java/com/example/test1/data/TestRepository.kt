package com.example.test1.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface TestRepository {
    fun getProducts() : Flow<List<String>>
}

class TestRepositoryImpl : TestRepository {

    override
    fun getProducts(): Flow<List<String>> = flow {
        emit(listOf("Product1", "Product2"))
    }
}