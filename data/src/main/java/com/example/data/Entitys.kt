package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Photos")
data class dbPhoto(
    @PrimaryKey
    val regular: String,
    val image:ByteArray
)

