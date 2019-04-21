package com.example.unsplashcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.unsplashcoroutines.PhotosFragment.PhotosFragment
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MainActivity : AppCompatActivity(), KoinComponent {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)

//        val photosViewModel:PhotosViewModel by inject()

        changeFragment(PhotosFragment.newInstanse())
    }


    fun changeFragment(fragment: Fragment) {
        var fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}
