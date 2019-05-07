package com.example.unsplashcoroutines.BigImale

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.unsplashcoroutines.R
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.ac_big_image.*

//TODO создать загрусчик и добовлять его через di *
//TODO добавить вию модель *
//TODO добавить информацию об авторе ----

class BigImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_big_image)
        Slidr.attach(this)
        title = intent.getStringExtra("author")
        Glide.with(this).load(intent.getStringExtra("url")).into(image)
        image.setOnClickListener {onImageClick()}
        btn_download.setOnClickListener(View.OnClickListener {onDownloadClick()})
    }

    fun onImageClick(){
        if(btn_add.isVisible){
            btn_add.isVisible = false
            btn_like.isVisible = false
            btn_download.isVisible = false
        }else{
            btn_add.isVisible = true
            btn_like.isVisible = true
            btn_download.isVisible = true
        }
    }
    fun onDownloadClick(){
        Toast.makeText(this,"download",Toast.LENGTH_LONG).show()
    }

}