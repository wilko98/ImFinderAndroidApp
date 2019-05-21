package com.example.unsplashcoroutines.di

import android.app.DownloadManager
import android.content.Context
import androidx.room.Room
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import com.example.unsplashcoroutines.Response.ConnectivityInterceptorImpl
import com.example.unsplashcoroutines.SavedPhotos.SavedPhotosViewModel

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {
    single{ MainActivity() }
    single { createDataBaseRoom(androidContext()) }
    single { createDownloader(get()) }
    single { ConnectivityInterceptorImpl( context = get() ) }
    single { NetworkService.invoke(get<ConnectivityInterceptorImpl>()) }
    single { PhotosViewModel(get(),get()) }
    single { SavedPhotosViewModel(get()) }

}

fun createDataBaseRoom(context: Context): com.example.data.DAO {
    return Room.databaseBuilder(context, com.example.data.DataBase::class.java,"results.db")
        .fallbackToDestructiveMigration()
        .build().userDao()
}

fun createDownloader(context: Context):Downloader{
    return Downloader(context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager)
}