package com.example.lab03_danp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lab03_danp.entities.Country

@Database(entities = [Country::class], version = 1, exportSchema = true)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDao
}