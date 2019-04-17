package com.example.unsplashcoroutines

import android.app.Application
import com.example.unsplashcoroutines.Response.Result

class ApplicationSingleton :Application(){

    companion object {
        lateinit var networkService:NetworkService
        lateinit var currentPhotos: ArrayList<Result>
    }

    override fun onCreate() {
        currentPhotos = ArrayList(10)
        networkService= NetworkService.invoke()
        super.onCreate()
    }
}