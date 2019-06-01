package com.example.domain.Service

import com.example.unsplashcoroutines.Response.Photo
import com.example.unsplashcoroutines.Response.SearchResponse
import kotlinx.coroutines.Deferred

interface PhotosService {
    fun getPhotos(query:String):SearchResponse
    fun getRandomPhotos(number: Int): Deferred<List<Photo>>
    fun insertPhoto(photo: Photo)
}