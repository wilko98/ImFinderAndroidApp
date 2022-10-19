package com.example.unsplashcoroutines.SavedPhotos

import androidx.lifecycle.ViewModel
import com.example.data.db.DAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class SavedPhotosViewModel(val dao: DAO) : ViewModel() {

    private lateinit var photos: List<com.example.data.dbPhoto>

    fun getPhotos(): List<com.example.data.dbPhoto> {
        runBlocking(Dispatchers.Default) {
            photos = dao.getPhotos()
        }
        return photos
    }

}