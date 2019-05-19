package com.example.unsplashcoroutines.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.Urls
import com.example.unsplashcoroutines.Response.User

@Entity(tableName = "Photos")
data class dbPhoto(
    @PrimaryKey
    val regular: String,
    val image:ByteArray
)

