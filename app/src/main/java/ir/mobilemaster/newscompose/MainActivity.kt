package ir.mobilemaster.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.mobilemaster.newscompose.domain.usecases.AppEntryUseCases
import ir.mobilemaster.newscompose.presentation.onBoarding.OnBoardingScreen
import ir.mobilemaster.newscompose.presentation.onBoarding.OnBoardingViewModel
import ir.mobilemaster.newscompose.ui.theme.NewsComposeTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                println("from main activity $it")
            }
        }
        setContent {
            NewsComposeTheme {
                val viewModel: OnBoardingViewModel by viewModels()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }
    }
}
