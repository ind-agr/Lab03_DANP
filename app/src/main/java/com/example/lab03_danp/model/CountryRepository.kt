package com.example.lab03_danp.model

import android.util.Log
import com.example.lab03_danp.entities.Country
import org.json.JSONArray

class CountryRepository {
    fun getCountries(nextPageNumber: Int): List<Country> {

        Log.d("nextPageNumber:",nextPageNumber.toString())

        val countries = arrayListOf<Country>()
        var country: Country


        return countries
    }

    


}

