package ir.mobilemaster.shopCompose.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import ir.mobilemaster.shopCompose.features.home.data.repositories.ShopRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(private val repository: ShopRepository) : ViewModel() {

    private val _shopList = MutableStateFlow<List<ShopModel>>(emptyList())
    val shopList: StateFlow<List<ShopModel>> = _shopList

    private val _selectedProduct = MutableStateFlow<ShopModel?>(null)
    val selectedNews: StateFlow<ShopModel?> = _selectedProduct

    fun fetchProductsList() {
        viewModelScope.launch {
            repository.getProductsList()
                .collect { productItem ->
                    _shopList.value = productItem
                }
        }
    }

    fun fetchProductDetails(id: Int) {
        viewModelScope.launch {
            repository.getProductDetails(id)
                .collect { productItem ->
                    _selectedProduct.value = productItem
                }
        }
    }
}
