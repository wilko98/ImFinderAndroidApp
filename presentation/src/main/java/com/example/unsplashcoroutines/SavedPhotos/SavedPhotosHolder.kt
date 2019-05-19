package com.example.unsplashcoroutines.SavedPhotos

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.MainActivity
import com.example.unsplashcoroutines.db.dbPhoto
import kotlinx.android.synthetic.main.li_saved_photo.view.*
import java.io.ByteArrayInputStream

class SavedPhotosHolder(v: View) : RecyclerView.ViewHolder(v){
    val image = v.saved_image
    fun bind(dbPhoto: dbPhoto){
        val bitmap = BitmapFactory.decodeByteArray(dbPhoto.image,0,dbPhoto.image.size)
        image.setImageBitmap(bitmap)
        image.setOnClickListener {
            v -> (image.context as MainActivity).dao.deletePhoto(dbPhoto)
        }
    }
}