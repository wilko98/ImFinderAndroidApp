package com.example.unsplashcoroutines.di

import android.content.Context
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.PhotosFragment.Simple
import org.koin.dsl.module.module

val appModule = module {
    single {Simple(get()) }
    single {NetworkService.invoke() }
    single { MainActivity() }



}

