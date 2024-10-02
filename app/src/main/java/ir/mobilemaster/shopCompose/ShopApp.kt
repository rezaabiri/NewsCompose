package ir.mobilemaster.shopCompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mobilemaster.shopCompose.features.home.ui.screens.NewsDetailScreen
import ir.mobilemaster.shopCompose.features.home.ui.screens.NewsListScreen

@Composable
fun NewsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "newsList") {
        composable("newsList") {
            NewsListScreen(
                viewModel = hiltViewModel(),
                onProductItemClick = { id ->
                    navController.navigate("newsDetail/$id")
                }
            )
        }
        composable("newsDetail/{newsId}") { backStackEntry ->
            val newsId = backStackEntry.arguments?.getString("newsId")?.toInt() ?: return@composable
            NewsDetailScreen(viewModel = hiltViewModel(), newsId = newsId)
        }
    }
}
