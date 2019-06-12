package com.example.data.domain.Interactors

import android.util.Log
import com.example.data.Exeptions.NoConnectivityException
import com.example.data.NetworkService
import com.example.data.domain.model.Response.PhotoResult
import com.example.data.domain.model.Response.SearchResponse
import kotlinx.coroutines.*
import retrofit2.Response
import retrofit2.http.Query

class NetworkInteractor(val networkService: NetworkService) {
    suspend fun getPhotos(query: String): SearchResponse? {
            try {
                return networkService.getPhotos(query).await().body()
//                Log.i("retrofitResponse",result?.code().toString())
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
                return null
            }
        }

    suspend fun getRandomPhotos(query: Int): List<PhotoResult>? {
            try {
                return networkService.getRandomPhotos(query).await().body()
            } catch (e: NoConnectivityException) {
                Log.i("photosFragment", "No Connection")
                return null
            }
    }
}