package com.pablosj.cryptotutorialcompose.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("contributors")
    val contributors: Int, // 1131
    @SerializedName("followers")
    val followers: Int, // 161397
    @SerializedName("stars")
    val stars: Int, // 68773
    @SerializedName("subscribers")
    val subscribers: Int // 4874996
)