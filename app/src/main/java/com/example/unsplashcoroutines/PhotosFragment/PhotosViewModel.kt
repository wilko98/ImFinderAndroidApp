package com.example.unsplashcoroutines.PhotosFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashcoroutines.ApplicationSingleton
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.android.synthetic.main.fr_photos.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PhotosViewModel :ViewModel(){

    var networkService: NetworkService = ApplicationSingleton.networkService
    var searhResponse = MutableLiveData<SearhResponse>()
    var currentPhotos: ArrayList<Result> = ArrayList(10)


    fun searchPhotos(query:String){
        GlobalScope.launch(Dispatchers.Main) {
            searhResponse.value = networkService.getPhotos(query).await()
            currentPhotos.clear()
            currentPhotos.addAll(searhResponse.value!!.results)
        }
    }
}