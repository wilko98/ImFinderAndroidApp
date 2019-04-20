package com.example.unsplashcoroutines.di

import com.example.unsplashcoroutines.NetworkService
import org.koin.dsl.module.module

val appModule = module {
    single {
        NetworkService.invoke()
    }
    single {

    }



}