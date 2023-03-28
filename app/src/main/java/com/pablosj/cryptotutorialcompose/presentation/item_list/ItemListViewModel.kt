package com.pablosj.cryptotutorialcompose.presentation.item_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablosj.cryptotutorialcompose.common.Resource
import com.pablosj.cryptotutorialcompose.domain.use_case.get_item_list.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ItemListState())
    val state: State<ItemListState> = _state

    init {
        getListItems()
    }

    private fun getListItems() {
        getItemsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ItemListState(items = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ItemListState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = ItemListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}