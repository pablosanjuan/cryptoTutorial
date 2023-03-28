package com.pablosj.cryptotutorialcompose.presentation.item_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablosj.cryptotutorialcompose.common.Constants.PARAM_ITEM_ID
import com.pablosj.cryptotutorialcompose.common.Resource
import com.pablosj.cryptotutorialcompose.domain.use_case.get_item_details.GetItemDetailUseCase
import com.pablosj.cryptotutorialcompose.domain.use_case.get_item_list.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val getItemDetailUseCase: GetItemDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ItemDetailState())
    val state: State<ItemDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_ITEM_ID)?.let { itemId ->
            getItemDetails(itemId)
        }
    }

    private fun getItemDetails(itemId: String) {
        getItemDetailUseCase(itemId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ItemDetailState(item = result.data)
                }
                is Resource.Error -> {
                    _state.value = ItemDetailState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = ItemDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}