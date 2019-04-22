package com.example.unsplashcoroutines.di

import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import com.example.unsplashcoroutines.Response.ConnectivityInterceptorImpl
import org.koin.dsl.module.module

val appModule = module {
    single{ MainActivity() }
    single { ConnectivityInterceptorImpl( context = get() ) }
    single { NetworkService.invoke(get<ConnectivityInterceptorImpl>()) }
    single { PhotosViewModel(get()) }
}