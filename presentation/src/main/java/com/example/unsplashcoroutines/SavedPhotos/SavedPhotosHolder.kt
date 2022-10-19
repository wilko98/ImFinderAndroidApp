package com.example.unsplashcoroutines.SavedPhotos

import android.graphics.BitmapFactory
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.MainActivity
import kotlinx.android.synthetic.main.li_saved_photo.view.*

class SavedPhotosHolder(v: View) : RecyclerView.ViewHolder(v) {
    val image = v.saved_image
    fun bind(dbPhoto: com.example.data.dbPhoto) {
        val bitmap = BitmapFactory.decodeByteArray(dbPhoto.image, 0, dbPhoto.image.size)
        image.setImageBitmap(bitmap)
        image.setOnClickListener { v ->
            (image.context as MainActivity).dbInteractor.deletePhoto(dbPhoto)
        }
    }
}