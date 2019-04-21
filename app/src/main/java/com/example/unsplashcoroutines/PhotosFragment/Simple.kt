package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import com.example.unsplashcoroutines.NetworkService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Simple(private val networkService: NetworkService) {
    var a=0;
    suspend fun doing(){
        GlobalScope.launch {
            a = networkService.getPhotos("zzz").await().results.size
            Log.i("Simple",a.toString())
        }
    }

    fun simpleGet():Int{
        return a
    }


}