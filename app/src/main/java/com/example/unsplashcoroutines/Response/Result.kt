package com.example.unsplashcoroutines.Response

import androidx.room.*
import com.google.gson.annotations.Expose

@Entity(tableName = "Results")
data class Result(

    @PrimaryKey
    val id: String = "",
//    val color: String,
//    val created_at: String,
//    val description: String,
//    val height: Int,
//    val liked_by_user: Boolean,
    @ColumnInfo(name = "likes")
    var likes: Int =0,

    @Embedded
    var links: Links= Links("","",""),
    @Embedded
    var urls: Urls= Urls("","","","",""),
    @Embedded
    var user: User=User("","","","","","","","")
//    var width: Int=0
)