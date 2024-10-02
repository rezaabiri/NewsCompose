package ir.mobilemaster.shopCompose.features.home.data.data_source.remote

import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ShopApiService {
    @GET("products")
    suspend fun getProductsList(): List<ShopModel>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): ShopModel
}
