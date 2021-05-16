package com.example.devapplication.models

import com.google.gson.annotations.SerializedName

data class FeedResponse (
    @SerializedName("kind")
    var kind: String,
    @SerializedName("data")
    var data: FeedData
)