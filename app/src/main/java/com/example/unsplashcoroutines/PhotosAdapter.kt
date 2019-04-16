package com.example.unsplashcoroutines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PhotosAdapter(private val photosList: ArrayList<String>) :RecyclerView.Adapter<PhotosHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosHolder {
        return PhotosHolder(LayoutInflater.from(parent.context).inflate(R.layout.li_photo,parent,false))
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {

    }

}