package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.domain.Interactors.NetworkInteractor
import com.example.data.domain.model.Response.PhotoResult
import com.example.data.domain.model.Response.SearchResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosViewModel(val networkInteractor: NetworkInteractor, dbInteractor: NetworkInteractor) :
    ViewModel() {

    init {
        Log.i("photosFragment", "ViewModelCreated")
    }

    var searchResponse = MutableLiveData<SearchResponse>()
    var randomResponse = MutableLiveData<List<PhotoResult>>()
    fun searchPhotos(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
            searchResponse.value = networkInteractor.getPhotos(query)
        }
    }

    fun getRandomPhotos() {
        CoroutineScope(Dispatchers.Main).launch {
            randomResponse.value = networkInteractor.getRandomPhotos(30)
        }
    }

    override fun onCleared() {
        Log.i("photosFragment", "onCleared")
    }

}