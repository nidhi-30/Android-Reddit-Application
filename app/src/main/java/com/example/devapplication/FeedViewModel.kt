package com.example.devapplication

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.devapplication.models.Feed
import com.example.devapplication.models.FeedDetail
import com.example.devapplication.models.FeedResponse
import com.example.devapplication.repositories.FeedRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel constructor(private val repository: FeedRepository) : ViewModel() {

    val feedList = MutableLiveData<List<FeedDetail>>()
    val error = MutableLiveData<String>()
    var feedDetail : Feed? = null

    fun getFeeds(){
        val response = repository.getFeeds()
        Log.d("response", "$response")
        response.enqueue(object : Callback<FeedResponse> {
            override fun onResponse(call: Call<FeedResponse>, response: Response<FeedResponse>) {
                feedList.postValue(response.body()!!.data.children)
            }

            override fun onFailure(call: Call<FeedResponse>, t: Throwable) {
                error.postValue(t.message)
            }
        })
    }

}