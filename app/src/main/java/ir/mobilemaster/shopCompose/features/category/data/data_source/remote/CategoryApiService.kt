package ir.mobilemaster.shopCompose.features.category.data.data_source.remote

import retrofit2.http.GET

interface CategoryApiService {
    @GET("products/categories")
    suspend fun getCategories(): List<String>
}
