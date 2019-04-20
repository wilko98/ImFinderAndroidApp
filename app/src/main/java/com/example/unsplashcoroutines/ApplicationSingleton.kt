package com.example.unsplashcoroutines

import android.app.Application
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.di.appModule
import com.example.unsplashcoroutines.di.start
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class ApplicationSingleton :Application(){

    override fun onCreate() {
        super.onCreate()
        start(this)
    }
}