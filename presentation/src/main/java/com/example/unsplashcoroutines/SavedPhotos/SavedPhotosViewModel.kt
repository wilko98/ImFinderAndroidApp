package com.example.unsplashcoroutines.SavedPhotos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashcoroutines.db.DAO
import com.example.unsplashcoroutines.db.dbPhoto
import kotlinx.coroutines.*

class SavedPhotosViewModel(val dao: DAO) : ViewModel() {

    private lateinit var photos: List<dbPhoto>

    fun getPhotos(): List<dbPhoto> {
        runBlocking(Dispatchers.Default) {
            photos = dao.getPhotos()
        }
        return photos
    }

}