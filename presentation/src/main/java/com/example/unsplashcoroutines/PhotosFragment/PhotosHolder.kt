package com.example.unsplashcoroutines.PhotosFragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.SavedPhotos.SavedPhotosFragment
import kotlinx.android.synthetic.main.li_photo.view.*

class PhotosHolder(view:View):RecyclerView.ViewHolder(view){
    val image = view.li_image
//    val author = view.author
//    val likes = view.number_of_likes
    fun bind(photo: Result){
//        author.text = photo.user.username
//        likes.text = photo.likes.toString()
        Glide.with(itemView.context)
            .load(photo.urls.regular)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(image)

        image.setOnClickListener {
            (image.context as MainActivity).openBigImage(photo.urls.regular,photo.urls.full,this.image,photo)
        }
    }
}