package com.challenge.weather.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.challenge.weather.data.local.room.model.CityRoom

@Dao
interface CityRoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(cities: List<CityRoom>)

    @Query("SELECT COUNT(*) FROM CityRoom LIMIT 1")
    suspend fun existsCities(): Boolean

    @Query(
        """
        SELECT * FROM CityRoom 
        WHERE upper(name) || ' ' || upper(country) LIKE '%' || upper(:name) || '%'
        """
    )
    suspend fun searchByName(name: String): List<CityRoom>
}