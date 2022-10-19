package com.example.unsplashcoroutines

import android.app.Application
import com.example.unsplashcoroutines.di.appModule
import com.example.unsplashcoroutines.di.mNetworkModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

class ApplicationSingleton : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, mNetworkModule))
    }

}