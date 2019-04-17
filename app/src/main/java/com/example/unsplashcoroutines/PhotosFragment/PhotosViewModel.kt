package com.example.unsplashcoroutines.PhotosFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashcoroutines.ApplicationSingleton
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.android.synthetic.main.fr_photos.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotosViewModel :ViewModel(){


    init {
        Log.i("photosFragment","ViewModelCreated")
    }
    var networkService: NetworkService = MainActivity.networkService
    var searhResponse = MutableLiveData<SearhResponse>()
    var currentPhotos:List<Result> = ArrayList<Result>(10)

    fun searchPhotos(query:String){
        GlobalScope.launch(Dispatchers.Main) {
            searhResponse.value = networkService.getPhotos(query).await()
            currentPhotos = searhResponse.value!!.results
        }
    }

    override fun onCleared() {
        Log.i("photosFragment","onCleared")
    }

}