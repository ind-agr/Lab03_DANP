package com.example.lab03_danp.model

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lab03_danp.entities.Country

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<Country>)

    @Query("SELECT * FROM countries")
    fun pagingSource(query:String): PagingSource<Int, Country>

    @Query("DELETE FROM countries")
    suspend fun clearAll()
}