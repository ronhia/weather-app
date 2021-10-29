package com.challenge.weather.data.local.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CityRoom.TABLE_NAME)
data class CityRoom(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "local_id")
    val localId: Long = 0,
    val name: String,
    val country: String
) {
    companion object {
        const val TABLE_NAME = "CityRoom"
    }
}