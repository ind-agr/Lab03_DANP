package com.example.lab03_danp.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.lab03_danp.entities.Country
import com.example.lab03_danp.model.CountryRepository
import kotlinx.coroutines.flow.Flow

class CountryViewModel : ViewModel() {
    private val countryRepository: CountryRepository = CountryRepository()

    fun items(): Flow<PagingData<Country>> {

        val pager = Pager(
            PagingConfig(
                pageSize = 5,
                enablePlaceholders = false,
                prefetchDistance = 3)
        ) {
            CountryPagingSource(countryRepository)
        }.flow.cachedIn(viewModelScope)

        return pager

    }

}