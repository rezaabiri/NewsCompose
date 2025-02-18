package ir.mobilemaster.shopCompose.features.category.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobilemaster.shopCompose.features.category.data.data_source.remote.CategoryApiService
import ir.mobilemaster.shopCompose.features.category.data.repositories.CategoryRepository
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductDao
import ir.mobilemaster.shopCompose.features.home.data.data_source.remote.ShopApiService
import ir.mobilemaster.shopCompose.features.home.data.repositories.ShopRepository

@Module
@InstallIn(SingletonComponent::class)
object CategoryModule {

    @Provides
    fun provideCategoryRepository(apiService: CategoryApiService): CategoryRepository {
        return CategoryRepository(apiService)
    }
}
