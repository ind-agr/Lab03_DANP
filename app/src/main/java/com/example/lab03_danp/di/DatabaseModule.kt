package com.example.lab03_danp.di

import android.content.Context
import androidx.room.Room
import com.example.lab03_danp.model.CountryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CountryDatabase::class.java,
        "country_database"
    ).createFromAsset("database/countries.db").build()

    @Singleton
    @Provides
    fun provideDao(database: CountryDatabase) = database.countryDao()

}