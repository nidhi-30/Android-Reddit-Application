package com.example.devapplication.models

import com.google.gson.annotations.SerializedName

data class FeedData (
    @SerializedName("modhash")
    var modhash : String?,
    @SerializedName("dist")
    var dist : Int,
    @SerializedName("children")
    var children : List<FeedDetail>,
    @SerializedName("after")
    var after : String,
    @SerializedName("before")
    var before : String?
)