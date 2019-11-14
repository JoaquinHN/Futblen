package com.darax.futblen.api

import com.darax.futblen.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class TheSportDBApi {

    companion object {
        val BASE_URL = "https://www.thesportsdb.com/"
        val TSDB_API_KEY = "1/"
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL +
                            "api/v1/json/${TSDB_API_KEY}")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }
}