package com.example.unsplashcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)

    }


     fun changeFragment(fragment: Fragment){
         var fm:FragmentManager = supportFragmentManager
         fm.beginTransaction()
             .replace(R.id.container,fragment)
             .commitNow()
     }
}
