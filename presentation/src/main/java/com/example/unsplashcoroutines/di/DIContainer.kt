package com.example.unsplashcoroutines.di

import android.app.DownloadManager
import android.content.Context
import androidx.room.Room
import com.example.data.ConnectivityInterceptorImpl
import com.example.data.NetworkService
import com.example.data.db.DAO
import com.example.data.db.DataBase
import com.example.data.domain.Interactors.NetworkInteractor
import com.example.data.domain.Interactors.dbInteractor
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import com.example.unsplashcoroutines.SavedPhotos.SavedPhotosViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val mNetworkModule = module {
    single { ConnectivityInterceptorImpl(context = get()) }
    single { NetworkService.invoke(get<ConnectivityInterceptorImpl>()) }
    single { NetworkInteractor(get()) }
    single { dbInteractor(get()) }

}
val appModule = module {
    single { MainActivity() }
    single { createDataBaseRoom(androidContext()) }
    single { createDownloader(get()) }
    single { PhotosViewModel(get(), get()) }
    single { SavedPhotosViewModel(get()) }
}

fun createDataBaseRoom(context: Context): DAO {
    return Room.databaseBuilder(context, DataBase::class.java, "photoResults.db")
        .fallbackToDestructiveMigration()
        .build().userDao()
}

fun createDownloader(context: Context): Downloader {
    return Downloader(context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager)
}