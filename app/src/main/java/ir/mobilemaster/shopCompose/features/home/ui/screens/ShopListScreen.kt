package ir.mobilemaster.shopCompose.features.home.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.mobilemaster.shopCompose.features.home.ui.widgets.BottomNavigation
import ir.mobilemaster.shopCompose.features.home.ui.widgets.ProductItemRow
import ir.mobilemaster.shopCompose.features.home.viewmodel.ShopViewModel

@Composable
fun NewsListScreen(viewModel: ShopViewModel, onProductItemClick: (Int) -> Unit) {
    LaunchedEffect(Unit) {
        viewModel.fetchProductsList()
    }

    val productsList by viewModel.shopList.collectAsState()

    Box {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(fraction = 1f)
        ) {
            items(productsList){productsList ->
                ProductItemRow(productItem = productsList ) { onProductItemClick(productsList.id)}
            }
        }
        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)

        )
    }

}
