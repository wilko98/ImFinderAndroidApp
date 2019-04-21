package com.example.unsplashcoroutines.di

import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import org.koin.dsl.module.module

val appModule = module {
    single { NetworkService.invoke() }
    single { MainActivity() }
    single { PhotosViewModel(get()) }
}