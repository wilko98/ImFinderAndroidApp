package com.example.unsplashcoroutines.BigImale

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.unsplashcoroutines.R
import kotlinx.android.synthetic.main.ac_big_image.*

class BigImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_big_image)
        Log.i("image_url", "url" + intent.getStringExtra("url"))
        Glide.with(this).load(intent.getStringExtra("url")).into(image)

    }

}