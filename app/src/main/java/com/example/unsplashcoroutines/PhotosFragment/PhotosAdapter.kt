package com.example.unsplashcoroutines.PhotosFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.Response.Result

class PhotosAdapter(var photosList: List<Result>) :RecyclerView.Adapter<PhotosHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosHolder {
        return PhotosHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.li_photo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {
        val photo = photosList[position]
        holder.bind(photo)
//        Picasso.with(MainActivity.class).load(photo.urls.full).into(holder.image)

    }

}