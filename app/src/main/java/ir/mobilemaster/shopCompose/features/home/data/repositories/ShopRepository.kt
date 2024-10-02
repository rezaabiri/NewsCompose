package ir.mobilemaster.shopCompose.features.home.data.repositories

import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductDao
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductEntity
import ir.mobilemaster.shopCompose.features.home.data.data_source.remote.ShopApiService
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShopRepository @Inject constructor(
    private val apiService: ShopApiService, private val productDao: ProductDao
) {

    suspend fun getProductsList(): Flow<List<ShopModel>> = flow {
        val productsList = apiService.getProductsList()
        productDao.insertProductData(ProductEntity(data = productsList.listIterator().toString()))
        emit(productsList)
    }

    fun getProductDetails(id: Int): Flow<ShopModel> = flow {
        val productDetails = apiService.getProductDetails(id)
        emit(productDetails)
    }
}
