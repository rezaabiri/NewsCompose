package ir.mobilemaster.shopCompose.features.home.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductData(productEntity: ProductEntity)

    @Query("SELECT * FROM home_table")
    fun getAllProductData(): Flow<List<ProductEntity>>
}
