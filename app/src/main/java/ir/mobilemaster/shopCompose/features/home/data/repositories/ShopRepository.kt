package ir.mobilemaster.shopCompose.features.home.data.repositories

import ir.mobilemaster.shopCompose.features.home.data.data_source.remote.ShopApiService
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShopRepository @Inject constructor(private val apiService: ShopApiService) {

    fun getProductsList(): Flow<List<ShopModel>> = flow {
        val productsList = apiService.getProductsList()
        emit(productsList)
    }

    fun getProductDetails(id: Int): Flow<ShopModel> = flow {
        val productDetails = apiService.getProductDetails(id)
        emit(productDetails)
    }
}
