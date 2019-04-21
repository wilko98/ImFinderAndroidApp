package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosViewModel :ViewModel(){

    init {
        Log.i("photosFragment","ViewModelCreated")
    }
    var networkService: NetworkService = MainActivity.networkService
    var searchResponse = MutableLiveData<SearhResponse>()
    var currentQuery = ""

    fun searchPhotos(query:String){
        viewModelScope.launch(Dispatchers.Main) {
            currentQuery = query
            searchResponse.value = networkService.getPhotos(query).await()
        }
    }

    override fun onCleared() {
        Log.i("photosFragment","onCleared")
    }

}

