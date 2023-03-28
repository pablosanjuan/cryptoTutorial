package com.pablosj.cryptotutorialcompose.presentation

sealed class Screen(val route: String) {

    object ItemListScreen: Screen("item_list_screen")
    object ItemDetailsScreen: Screen("item_details_screen")
}
