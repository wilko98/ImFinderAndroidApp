package com.example.unsplashcoroutines.PhotosFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.R
import com.example.data.Response.PhotoResult

class PhotosAdapter(var photosList: List<PhotoResult>) :RecyclerView.Adapter<PhotosHolder>(){
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

    }

}