package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashcoroutines.ApplicationSingleton
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.MainActivity.Companion.networkService
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.android.synthetic.main.fr_photos.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class PhotosViewModel() :ViewModel(){

    init {
        Log.i("photosFragment","ViewModelCreated")
    }
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

