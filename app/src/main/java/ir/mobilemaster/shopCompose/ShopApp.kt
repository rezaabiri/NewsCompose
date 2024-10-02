package ir.mobilemaster.shopCompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mobilemaster.shopCompose.features.home.ui.screens.ShopDetailScreen
import ir.mobilemaster.shopCompose.features.home.ui.screens.ProductListScreen

@Composable
fun ShopApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreen(
                viewModel = hiltViewModel(),
                onProductItemClick = { id ->
                    navController.navigate("productDetail/$id")
                }
            )
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: return@composable
            ShopDetailScreen(viewModel = hiltViewModel(), productId = productId)
        }
    }
}
