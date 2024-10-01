package ir.mobilemaster.newscompose.presentation.navgraph

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ir.mobilemaster.newscompose.presentation.onBoarding.OnBoardingScreen
import ir.mobilemaster.newscompose.presentation.onBoarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startingDestination: String,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startingDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(
                route = Route.NewsNavigatorScreen.route
            ) {

            }
        }
    }
}