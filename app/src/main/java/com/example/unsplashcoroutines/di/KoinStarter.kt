package com.example.unsplashcoroutines.di

import android.content.Context
import org.koin.android.ext.koin.with
import org.koin.standalone.StandAloneContext.startKoin

/**
    Используется на тот случай если app клас написан на java
 */
fun start(context: Context){
        startKoin(listOf(appModule)) with context
}

