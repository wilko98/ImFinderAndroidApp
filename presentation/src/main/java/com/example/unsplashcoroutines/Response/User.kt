package com.example.unsplashcoroutines.Response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    val first_name: String?,
    val user_id: String?,
    val instagram_username: String?,
    val last_name: String?,
    val name: String?,
    val portfolio_url: String?,
    val twitter_username: String?,
    val username: String
)