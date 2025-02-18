package ir.mobilemaster.shopCompose.features.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobilemaster.shopCompose.features.category.data.repositories.CategoryRepository
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel
import ir.mobilemaster.shopCompose.features.home.data.repositories.ShopRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {

    private val _categoryList = MutableStateFlow<List<String>>(emptyList())
    val categoryList: StateFlow<List<String>> = _categoryList

    fun fetchProductsList() {
        viewModelScope.launch {
            repository.getCategories()
                .collect { productItem ->
                    _categoryList.value = productItem
                }
        }
    }
}
