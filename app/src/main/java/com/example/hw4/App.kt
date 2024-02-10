package com.example.hw4

import android.app.Application
import androidx.room.Room
import com.example.hw4.data.room.AppDatabase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }

    /*Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()*/
}