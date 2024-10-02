package ir.mobilemaster.shopCompose.core

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductDao
import ir.mobilemaster.shopCompose.features.home.data.data_source.local.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): ProductDao
}
