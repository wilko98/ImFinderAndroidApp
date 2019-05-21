package com.example.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface DAO {
    @Query("SELECT * FROM Photos")
    fun getPhotos():List<dbPhoto>
    @Insert(onConflict = REPLACE)
    fun insertPhoto(dbPhoto: dbPhoto)
    @Delete
    fun deletePhoto(dbPhoto: dbPhoto)
}