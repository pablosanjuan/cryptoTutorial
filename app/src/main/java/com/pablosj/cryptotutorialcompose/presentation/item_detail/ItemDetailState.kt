package com.pablosj.cryptotutorialcompose.presentation.item_detail

import com.pablosj.cryptotutorialcompose.domain.model.ItemDetail

data class ItemDetailState(
    val isLoading: Boolean = false,
    val item: ItemDetail? = null,
    val error: String = "",
)
