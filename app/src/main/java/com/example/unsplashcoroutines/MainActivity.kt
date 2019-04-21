package com.example.unsplashcoroutines

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.unsplashcoroutines.PhotosFragment.PhotosFragment
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import com.example.unsplashcoroutines.PhotosFragment.Simple
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.standalone.KoinComponent
import org.koin.standalone.get

class MainActivity : AppCompatActivity(), KoinComponent {

    companion object {
        lateinit var photosViewModel: PhotosViewModel
        lateinit var networkService:NetworkService
        lateinit var s: Simple
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
        val simple:Simple = get()
//        s=simple

        GlobalScope.launch {
            simple.doing()
        }
        changeFragment(PhotosFragment.newInstanse())
        networkService = NetworkService.invoke()
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
    }


    fun changeFragment(fragment: Fragment) {
        var fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}
