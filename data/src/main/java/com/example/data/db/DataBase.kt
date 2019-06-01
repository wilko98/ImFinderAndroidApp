package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dbPhoto

@Database(entities = [dbPhoto::class], version = 1,exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): DAO
}