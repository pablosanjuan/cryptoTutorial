package com.pablosj.cryptotutorialcompose.data.repository

import com.pablosj.cryptotutorialcompose.data.remote.DataSourceApi
import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDetailDto
import com.pablosj.cryptotutorialcompose.data.remote.dto.ItemDto
import com.pablosj.cryptotutorialcompose.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val api: DataSourceApi
) : ItemRepository {

    override suspend fun getItemList(): List<ItemDto> {
        return api.getItems()
    }

    override suspend fun getItemsById(coinId: String): ItemDetailDto {
        return api.getItemById(coinId)
    }
}