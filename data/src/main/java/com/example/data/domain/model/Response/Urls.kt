package com.example.data.domain.model.Response

import androidx.room.Entity

@Entity
data class Urls(

    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)