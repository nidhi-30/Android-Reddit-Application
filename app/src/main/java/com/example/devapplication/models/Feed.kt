package com.example.devapplication.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

data class Feed(
    @SerializedName("title")
    var title: String,
    @SerializedName("author")
    var author: String,
    @SerializedName("category")
    var category: String?,
    @SerializedName("url")
    var url : String

)