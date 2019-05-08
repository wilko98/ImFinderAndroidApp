package com.example.unsplashcoroutines.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearhResponse

@Database(entities = arrayOf(Result::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): DAO
}