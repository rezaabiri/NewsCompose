package ir.mobilemaster.shopCompose.features.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductDao
import ir.mobilemaster.shopCompose.features.home.data.data_source.remote.ShopApiService
import ir.mobilemaster.shopCompose.features.home.data.repositories.ShopRepository

@Module
@InstallIn(SingletonComponent::class)
object ShopModule {

    @Provides
    fun provideShopRepository(apiService: ShopApiService, productDao: ProductDao): ShopRepository {
        return ShopRepository(apiService, productDao)
    }
}
