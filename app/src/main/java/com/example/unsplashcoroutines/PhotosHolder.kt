package com.example.unsplashcoroutines

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.li_photo.view.*

class PhotosHolder(view:View):RecyclerView.ViewHolder(view){
    val image = view.li_image
    val author = view.author
    val likes = view.number_of_likes
}