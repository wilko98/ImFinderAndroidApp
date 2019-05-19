package com.example.unsplashcoroutines.Random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.NetworkService
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.Response.Result
import kotlinx.android.synthetic.main.fr_random.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.net.URI

class RandomFragment() : Fragment(){

    val networkService:NetworkService  by inject()
    companion object{
        fun newInstance():RandomFragment{
            return RandomFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_random,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var randomPhoto:Result
        randomBtn.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                randomPhoto = networkService.getRandomPhoto().await()
                Glide.with(this@RandomFragment).load(randomPhoto.urls.regular).into(randomPhotoIv)
                randomPhotoIv.setOnClickListener {
                    (context as MainActivity).openBigImage(randomPhoto.urls.regular,randomPhotoIv,randomPhoto)
                }
            }
        }
    }

}