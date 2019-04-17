package com.example.unsplashcoroutines

import android.app.Application
import android.graphics.Typeface

class ApplicationSingleton :Application(){

    companion object {
        lateinit var networkService:NetworkService
    }

    override fun onCreate() {
        networkService= NetworkService.invoke()
        super.onCreate()
    }
}