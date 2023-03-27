package com.pablosj.cryptotutorialcompose.domain.use_case.get_item_details

import com.pablosj.cryptotutorialcompose.common.Resource
import com.pablosj.cryptotutorialcompose.data.remote.dto.toItem
import com.pablosj.cryptotutorialcompose.data.remote.dto.toItemDetail
import com.pablosj.cryptotutorialcompose.domain.model.Item
import com.pablosj.cryptotutorialcompose.domain.model.ItemDetail
import com.pablosj.cryptotutorialcompose.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetItemDetailUseCase @Inject constructor(
    private val repository: ItemRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<ItemDetail>> = flow {
        try {
            emit(Resource.Loading())
            val item = repository.getItemsById(coinId).toItemDetail()
            emit(Resource.Success(item))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Internet Error"))
        }
    }
}