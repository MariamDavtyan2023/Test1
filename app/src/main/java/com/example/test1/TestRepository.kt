package com.example.test1

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TestRepository {

    fun getProducts(): Flow<List<String>> = flow {
        emit(listOf("Product1", "Product2"))
    }
}