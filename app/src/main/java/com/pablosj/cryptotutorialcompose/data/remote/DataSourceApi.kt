package com.pablosj.cryptotutorialcompose.data.remote

import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDetailDto
import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DataSourceApi {

    @GET("/v1/coins")
    suspend fun  getItems(): List<ItemDto>

    @GET("/v1/coins/{coinId}")
    suspend fun  getItemById(@Path("coinId") coinId: String): ItemDetailDto

}