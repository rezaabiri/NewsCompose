import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel

object Converters {

    @TypeConverter
    fun toJson(value: List<ShopModel>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toList(value: String?): List<ShopModel>? {
        val listType = object : TypeToken<List<ShopModel>>() {}.type
        return Gson().fromJson(value, listType)
    }
}
