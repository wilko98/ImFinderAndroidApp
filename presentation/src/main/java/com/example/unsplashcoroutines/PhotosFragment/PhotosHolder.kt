package com.example.unsplashcoroutines.PhotosFragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.unsplashcoroutines.MainActivity
import com.example.data.domain.model.Response.PhotoResult
import kotlinx.android.synthetic.main.li_photo.view.*

class PhotosHolder(view:View):RecyclerView.ViewHolder(view){
    val image = view.li_image
//    val author = view.author
//    val likes = view.number_of_likes
    fun bind(photoResult: PhotoResult){
//        author.text = photoResult.user.username
//        likes.text = photoResult.likes.toString()
        Glide.with(itemView.context)
            .load(photoResult.urls.regular)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(image)

        image.setOnClickListener {
            (image.context as MainActivity).openBigImage(photoResult.urls.regular,photoResult.urls.full,this.image,photoResult)
        }
    }
}