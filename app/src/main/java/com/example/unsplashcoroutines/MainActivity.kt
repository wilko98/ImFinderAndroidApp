package com.example.unsplashcoroutines

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.unsplashcoroutines.PhotosFragment.PhotosFragment
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var photosViewModel: PhotosViewModel
        lateinit var networkService:NetworkService
    }

//    val networkService:NetworkService by inject()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
        changeFragment(PhotosFragment.newInstanse())
        networkService = NetworkService.invoke()
//        photosViewModel = PhotosViewModel(networkService)
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
    }


    fun changeFragment(fragment: Fragment) {
        var fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}