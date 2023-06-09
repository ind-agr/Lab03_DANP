package com.example.lab03_danp.model

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.lab03_danp.di.DatabaseModule.provideDatabase
import com.example.lab03_danp.entities.Country
import com.example.lab03_danp.paging.CountryPagingSource

class CountryRepository {
    fun getCountries(page: Int, pageSize: Int): List<Country> {



        val countries = arrayListOf<Country>()
        var country: Country



        return countries
    }


    /*fun getCountries()= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { CountryPagingSource(countryDao) }
    ).liveData*/
}

