package com.example.devapplication.models


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class FeedDetail(
    @SerializedName("kind")
    var kind : String,
    @SerializedName("data")
    var data : Feed
) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {

    }
}