package ir.mobilemaster.newscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import ir.mobilemaster.newscompose.presentation.onBoarding.OnBoardingScreen
import ir.mobilemaster.newscompose.presentation.onBoarding.components.OnBoardingPage
import ir.mobilemaster.newscompose.presentation.onBoarding.components.PageIndicator
import ir.mobilemaster.newscompose.presentation.onBoarding.pages
import ir.mobilemaster.newscompose.ui.theme.NewsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            NewsComposeTheme {
                Column {
                    OnBoardingScreen()
                }
            }
        }
    }
}
