package com.example.test1

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.test1.core.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TestApplication: Application(), LifecycleObserver {

    private lateinit var currentActivityState: Lifecycle

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupKoin()
        currentActivityState  = ProcessLifecycleOwner.get().lifecycle
        currentActivityState.addObserver(this)
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TestApplication)
            androidFileProperties()
            modules(appComponent)
        }
    }

    companion object {
        lateinit var instance: Application
    }
}