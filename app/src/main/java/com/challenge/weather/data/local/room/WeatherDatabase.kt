package com.challenge.weather.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.challenge.weather.data.local.room.dao.CityRoomDao
import com.challenge.weather.data.local.room.model.CityRoom

@Database(
    entities = [
        CityRoom::class
    ],
    version = 1
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun cityRoomDao(): CityRoomDao

    companion object {

        const val DATABASE_NAME = "weather.db"

        @Volatile
        private var instance: WeatherDatabase? = null

        private fun buildDatabase(context: Context) = Room
            .databaseBuilder(context, WeatherDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

        fun getInstance(context: Context): WeatherDatabase {
            if (instance == null) {
                synchronized(WeatherDatabase::class) { instance = buildDatabase(context) }
            }
            return instance!!
        }
    }

}