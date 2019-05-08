package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashcoroutines.Exeptions.NoConnectivityException
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosViewModel(val networkService: NetworkService) : ViewModel() {

    init {
        Log.i("photosFragment", "ViewModelCreated")
    }

    var searchResponse = MutableLiveData<SearhResponse>()
    var currentQuery = ""
    fun searchPhotos(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            currentQuery = query
            try {
                searchResponse.value = networkService.getPhotos(query).await()
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
            }
        }
    }

    override fun onCleared() {
        Log.i("photosFragment", "onCleared")
    }

}