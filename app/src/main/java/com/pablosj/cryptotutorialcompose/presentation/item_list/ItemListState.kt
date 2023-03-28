package com.pablosj.cryptotutorialcompose.presentation.item_list

import com.pablosj.cryptotutorialcompose.domain.model.Item

data class ItemListState(
    val isLoading: Boolean = false,
    val items: List<Item> = emptyList(),
    val error: String = "",
)
