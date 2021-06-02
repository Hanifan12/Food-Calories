package com.capstone.foodcalories.api

import com.capstone.foodcalories.model.remote.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CnnApi {
    @GET("cnn-news/")
    fun getNewsCNN(): Call<NewsResponse>

    @GET("cnn-news/{type}")
    fun getNewsCCNType(@Path("type") type: String ) : Call<NewsResponse>
}