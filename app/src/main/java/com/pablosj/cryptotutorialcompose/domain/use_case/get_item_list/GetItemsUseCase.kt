package com.pablosj.cryptotutorialcompose.domain.use_case.get_item_list

import com.pablosj.cryptotutorialcompose.common.Resource
import com.pablosj.cryptotutorialcompose.data.remote.dto.toItem
import com.pablosj.cryptotutorialcompose.domain.model.Item
import com.pablosj.cryptotutorialcompose.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: ItemRepository
) {

    operator fun invoke(): Flow<Resource<List<Item>>> = flow {
        try {
            emit(Resource.Loading<List<Item>>())
            val items = repository.getItemList().map { it.toItem() }
            emit(Resource.Success(items))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Item>>(e.localizedMessage ?: "Error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Item>>("Internet Error"))
        }
    }
}