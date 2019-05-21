package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashcoroutines.Exeptions.NoConnectivityException
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.Result
import com.example.data.DAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosViewModel(val networkService: NetworkService,val dao: com.example.data.DAO) : ViewModel() {

    init {
        Log.i("photosFragment", "ViewModelCreated")
    }


    var searchResponse = MutableLiveData<List<Result>>()
    var randomResponse = MutableLiveData<List<Result>>()
    var currentQuery = ""
    fun searchPhotos(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            currentQuery = query

            try {
                val response = networkService.getPhotos(query).await()
                searchResponse.value = response.results
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
            }
        }
    }
    fun getRandomPhotos() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val randomPhotosArray = networkService.getRandomPhotos(30).await()
                randomResponse.value = randomPhotosArray
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
            }
        }
    }

    override fun onCleared() {
        Log.i("photosFragment", "onCleared")
    }

}