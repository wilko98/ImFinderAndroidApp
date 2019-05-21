package com.example.unsplashcoroutines


import com.example.data.BuildConfig
import com.example.unsplashcoroutines.Response.ConnectivityInterceptor
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearchResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
    ): Deferred<SearchResponse>

    @GET("/users/{username}/photos")
    fun getUsersPhotos(
        @Path("username") username: String
    ): Deferred<SearchResponse>

    @GET("/photos/random")
    fun getRandomPhoto(): Deferred<Result>

    @GET("/photos/random")
    fun getRandomPhotos(
        @Query("count")
        number: Int
    ): Deferred<List<Result>>


    companion object {
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor): NetworkService {

            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("client_id", com.example.data.BuildConfig.ACCESS_KEY)
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