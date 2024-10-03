package ir.mobilemaster.shopCompose

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mobilemaster.shopCompose.features.home.ui.screens.ShopDetailScreen
import ir.mobilemaster.shopCompose.features.home.ui.screens.ProductListScreen
import ir.mobilemaster.shopCompose.features.profile.ui.ProfileScreen

@Composable
fun ShopApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "productList") {
        composable(
            "productList",
        ) {
            ProductListScreen(
                viewModel = hiltViewModel(),
                navController
            )
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: return@composable
            ShopDetailScreen(viewModel = hiltViewModel(), productId = productId)
        }
        composable(
            "profile",
           enterTransition = {
               slideIntoContainer(
                   AnimatedContentTransitionScope.SlideDirection.Left,
                   animationSpec = tween(500),
               )
           },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            }
        ) { navBackStackEntry ->
            ProfileScreen()

        }
    }
}
