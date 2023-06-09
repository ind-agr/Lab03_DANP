package com.example.lab03_danp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.lab03_danp.entities.Country
import com.example.lab03_danp.model.CountryRepository
import java.io.IOException

class CountryPagingSource(
    private val countryRepository: CountryRepository
) : PagingSource<Int, Country>() {

    override val keyReuseSupported: Boolean = true

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Country> {
        return try {
            val nextPageNumber = params.key ?: 1
            val countries = countryRepository.getCountries(nextPageNumber)

            return PagingSource.LoadResult.Page(
                data = countries ?: listOf(),
                prevKey = if (nextPageNumber > 1) nextPageNumber - 1 else 1,
                nextKey = nextPageNumber + 1
            )

        } catch (exception: IOException) {
            return PagingSource.LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Country>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}