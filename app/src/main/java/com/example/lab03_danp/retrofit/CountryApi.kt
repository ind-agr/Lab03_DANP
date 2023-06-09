package com.example.lab03_danp.retrofit

import androidx.room.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CountryApi {
    @GET
    suspend fun getCountries(@retrofit2.http.Query("page") page: Int, @retrofit2.http.Query("limit") limit: Int): UsersResponse


    companion object {

        private const val BASE_URL = "https://dummyapi.io/data/v1/"

        operator fun invoke(): UsersApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getRetrofitClient())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(UsersApi::class.java)
        }

        private fun getRetrofitClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("Accept", "application/json")
                        it.addHeader("app-id", "62cceaafb592b449c3aad899")
                    }.build())
                }.also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
        }
    }
}