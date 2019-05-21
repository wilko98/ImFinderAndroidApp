package com.example.unsplashcoroutines.SavedPhotos

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.*

class SavedPhotosViewModel(val dao: com.example.data.DAO) : ViewModel() {

    private lateinit var photos: List<com.example.data.dbPhoto>

    fun getPhotos(): List<com.example.data.dbPhoto> {
        runBlocking(Dispatchers.Default) {
            photos = dao.getPhotos()
        }
        return photos
    }

}