package com.example.lab03_danp.model

import com.example.lab03_danp.retrofit.CountryApi

class CountryRepositoryImpl
    (
    private val api: CountryApi
            ): CountryRepository() {
}