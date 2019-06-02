package com.example.data.domain.Interactors

import android.util.Log
import com.example.data.Exeptions.NoConnectivityException
import com.example.data.NetworkService
import com.example.data.domain.model.Response.PhotoResult
import com.example.data.domain.model.Response.SearchResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import retrofit2.http.Query

class NetworkInteractor(val networkService: NetworkService) {
    fun getPhotos(query: String): SearchResponse? {
        var result: SearchResponse ?= null
        runBlocking(Dispatchers.Default) {
            try {
                result = networkService.getPhotos(query).await()
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
            }
        }
        return result
    }

    fun getRandomPhotos(query: Int): List<PhotoResult> {
        var result: List<PhotoResult> = ArrayList(0)
        runBlocking(Dispatchers.Default) {
            try {
                result = networkService.getRandomPhotos(query).await()
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
            }
        }
        return result
    }
}