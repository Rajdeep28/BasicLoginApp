package com.example.basicloginapp.network

import com.example.basicloginapp.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    //repositories?q=newyork
    @GET("repositories")
    fun getDataFromApi(@Query("q") query: String) : Call<RecyclerList>

}