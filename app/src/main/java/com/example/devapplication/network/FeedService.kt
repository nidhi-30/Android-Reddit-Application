package com.example.devapplication.network

import com.example.devapplication.models.FeedResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FeedService {

    @GET(".json")
    fun getFeeds() : Call<FeedResponse>

    companion object {

        var retrofitService: FeedService? = null

        fun getInstance() : FeedService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.reddit.com/hot/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(FeedService::class.java)
            }
            return retrofitService!!
        }
    }

}