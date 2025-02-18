package ir.mobilemaster.shopCompose.features.category.data.repositories

import ir.mobilemaster.shopCompose.features.category.data.data_source.remote.CategoryApiService
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductDao
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductEntity
import ir.mobilemaster.shopCompose.features.home.data.data_source.remote.ShopApiService
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val apiService: CategoryApiService
) {

    suspend fun getCategories(): Flow<List<String>> = flow {
        val productsList = apiService.getCategories()
        emit(productsList)
    }
}
