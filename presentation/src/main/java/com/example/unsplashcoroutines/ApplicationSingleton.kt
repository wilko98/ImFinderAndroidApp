package com.example.unsplashcoroutines

import android.app.Application
import androidx.fragment.app.FragmentManager
import com.example.unsplashcoroutines.di.appModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.KoinComponent

class ApplicationSingleton :Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin (this, listOf(appModule))
    }

}