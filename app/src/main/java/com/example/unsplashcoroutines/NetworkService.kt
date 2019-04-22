package com.example.unsplashcoroutines


import com.example.unsplashcoroutines.Response.ConnectivityInterceptor
import com.example.unsplashcoroutines.Response.ConnectivityInterceptorImpl
import com.example.unsplashcoroutines.Response.SearhResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface NetworkService {

    @GET("/search/photos")
    fun getPhotos(
        @Query("query")
        query: String
    ): Deferred<SearhResponse>


    companion object{
        operator fun invoke(connectivityInterceptor: ConnectivityInterceptor):NetworkService{

            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("client_id",BuildConfig.ACCESS_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }


            val OkHttpClient =OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .readTimeout(10L,TimeUnit.SECONDS)
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