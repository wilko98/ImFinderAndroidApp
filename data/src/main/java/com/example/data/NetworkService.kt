package com.example.data

import com.example.data.domain.model.Response.PhotoResult
import com.example.data.domain.model.Response.SearchResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface NetworkService {

    @GET("/search/photos")
    fun getPhotos(
        @Query("query")
        query: String
    ): Deferred<Response<SearchResponse>>

    @GET("/users/{username}/photos")
    fun getUsersPhotos(
        @Path("username") username: String
    ): Deferred<Response<SearchResponse>>

    @GET("/photos/random")
    fun getRandomPhoto(): Deferred<Response<PhotoResult>>

    @GET("/photos/random")
    fun getRandomPhotos(
        @Query("count")
        number: Int
    ): Deferred<Response<List<PhotoResult>>>

    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): NetworkService {

            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("client_id", BuildConfig.ACCESS_KEY)
                    .addQueryParameter("per_page", "30")
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }

            val OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .readTimeout(10L, TimeUnit.SECONDS)
                .build()

            return Retrofit
                .Builder()
                .client(OkHttpClient)
                .baseUrl(BuildConfig.API_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(NetworkService::class.java)
        }

    }

}