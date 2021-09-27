package com.example.basicloginapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//url = https://api.github.com/search/repositories?q=newyork
class RetroInstance {
    companion object{
        var baseUrl = "https://api.github.com/search/"
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}