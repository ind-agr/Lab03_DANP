package com.example.lab03_danp.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.lab03_danp.paging.CountryPagingSource
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryDao: CountryDao) {
    fun getCountries()= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { CountryPagingSource(countryDao) }
    ).liveData
}

