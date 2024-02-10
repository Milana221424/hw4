package com.example.hw4.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw4.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():LoveDao
}