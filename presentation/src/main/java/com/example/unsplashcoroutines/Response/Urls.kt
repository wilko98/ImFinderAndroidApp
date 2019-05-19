package com.example.unsplashcoroutines.Response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Urls(

    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)