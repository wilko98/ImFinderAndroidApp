package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Exeptions.NoConnectivityException
import com.example.data.NetworkRepository
import com.example.data.Response.PhotoResult
import com.example.data.db.DAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosViewModel(val networkService: NetworkRepository, val dao: DAO) : ViewModel() {

    init {
        Log.i("photosFragment", "ViewModelCreated")
    }


    var searchResponse = MutableLiveData<List<PhotoResult>>()
    var randomResponse = MutableLiveData<List<PhotoResult>>()
    var currentQuery = ""
    fun searchPhotos(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            currentQuery = query

            try {
                val response = networkService.getPhotos(query).await()
                searchResponse.value = response.photoResults
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