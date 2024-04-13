package com.example.test1.core.di

import com.example.test1.data.TestRepository
import com.example.test1.data.TestRepositoryImpl
import org.koin.dsl.module

internal val apiModule = module {
    // This module created for API modules
    single<TestRepository> {
        TestRepositoryImpl()
    }
}