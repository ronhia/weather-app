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
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun cityRoomDao(): CityRoomDao

    companion object {

        const val DATABASE_NAME = "weather.db"

        fun buildDatabase(context: Context): WeatherDatabase {
            return Room.databaseBuilder(context, WeatherDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}