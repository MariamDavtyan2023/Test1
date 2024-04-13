package com.example.test1.core.di

import com.example.test1.ui.TestFragment
import com.example.test1.ui.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val appModule = module {
    scope(named<TestFragment>()) {
        viewModel {
            TestViewModel(get())
        }
    }
}