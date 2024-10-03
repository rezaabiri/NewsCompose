package ir.mobilemaster.shopCompose.features.home.ui.screens

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.mobilemaster.shopCompose.features.home.ui.widgets.BottomNavigation
import ir.mobilemaster.shopCompose.features.home.ui.widgets.ProductItemRow
import ir.mobilemaster.shopCompose.features.home.viewmodel.ShopViewModel

@Composable
fun ProductListScreen(viewModel: ShopViewModel, navController: NavController) {
    LaunchedEffect(Unit) {
        viewModel.fetchProductsList()
    }

    val productsList by viewModel.shopList.collectAsState()

    Box {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(fraction = 1f)
        ) {
            itemsIndexed(productsList){index, item ->
                if (index == productsList.size -1){
                    Box(modifier = Modifier.padding(bottom = 100.dp)){
                        ProductItemRow(productItem = item) {
                            navController.navigate("productDetail/${item.id}")
                        }
                    }
                }else ProductItemRow(productItem = item) {
                    navController.navigate("productDetail/${item.id}")
                }
            }
        }
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            navController

        )
    }

}
