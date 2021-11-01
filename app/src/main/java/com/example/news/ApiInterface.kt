package com.example.news

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String = "jp",
        @Query("apiKey") apiKey: String = "62b1468c8a1f4c7bbf0b6130386bbcb5",
    ): Call<NewsList>
}