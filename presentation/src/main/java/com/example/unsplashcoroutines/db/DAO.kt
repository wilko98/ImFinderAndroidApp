package com.example.unsplashcoroutines.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.Deferred


@Dao
interface DAO {
    @Query("SELECT * FROM Photos")
    fun getPhotos():List<dbPhoto>
    @Insert(onConflict = REPLACE)
    fun insertPhoto(dbPhoto: dbPhoto)
    @Delete
    fun deletePhoto(dbPhoto: dbPhoto)
}