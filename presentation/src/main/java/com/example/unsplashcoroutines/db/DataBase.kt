package com.example.unsplashcoroutines.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [dbPhoto::class], version = 1,exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): DAO
}