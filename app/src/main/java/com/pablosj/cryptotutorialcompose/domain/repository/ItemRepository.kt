package com.pablosj.cryptotutorialcompose.domain.repository

import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDetailDto
import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDto

interface ItemRepository {

    suspend fun getItemList(): List<ItemDto>

    suspend fun getItemsById(coinId: String): ItemDetailDto

}