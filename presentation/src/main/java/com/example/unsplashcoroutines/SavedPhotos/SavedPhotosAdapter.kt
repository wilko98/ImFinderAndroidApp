package com.example.unsplashcoroutines.SavedPhotos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.R

class SavedPhotosAdapter(var savedPhotos: List<com.example.data.dbPhoto>) :
    RecyclerView.Adapter<SavedPhotosHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedPhotosHolder {
        return SavedPhotosHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.li_saved_photo, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return savedPhotos.size
    }

    override fun onBindViewHolder(holder: SavedPhotosHolder, position: Int) {
        val savedPhoto = savedPhotos[position]
        holder.bind(savedPhoto)
    }
}