package com.example.unsplashcoroutines.Response

import androidx.room.*
import com.google.gson.annotations.Expose

data class Result(
    val color: String,
    val created_at: String,
    val description: String,
    val height: Int,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User,
    val width: Int
)