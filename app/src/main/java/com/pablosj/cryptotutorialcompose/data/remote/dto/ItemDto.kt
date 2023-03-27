package com.pablosj.cryptotutorialcompose.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.pablosj.cryptotutorialcompose.domain.model.Item

data class ItemDto(
    @SerializedName("id")
    val id: String, // btc-bitcoin
    @SerializedName("is_active")
    val isActive: Boolean, // true
    @SerializedName("is_new")
    val isNew: Boolean, // false
    @SerializedName("name")
    val name: String, // Bitcoin
    @SerializedName("rank")
    val rank: Int, // 1
    @SerializedName("symbol")
    val symbol: String, // BTC
    @SerializedName("type")
    val type: String // coin
)

fun ItemDto.toItem(): Item {
    return Item(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}