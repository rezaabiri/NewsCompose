package ir.mobilemaster.newscompose.presentation.card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.mobilemaster.newscompose.R
import ir.mobilemaster.newscompose.ui.theme.NewsComposeTheme

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsComposeTheme {
                Box (
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ){
                    CardWidget(
                        image = R.drawable.onboarding1,
                        title = "رضا عبیری",
                        description = "اینجا توضیحات هستش که دارم وارد میکنم ببینم به چه صورت در آمده استاینجا توضیحات هستش که دارم وارد میکنم ببینم به چه صورت در آمده استاینجا توضیحات هستش که دارم وارد میکنم ببینم به چه صورت در آمده است",
                        publisher = Publisher(
                            avatar = R.drawable.onboarding3,
                            name = "رضا عبیری",
                            job = "برنامه نویس موبایل"
                        )
                    )
                }

            }
        }
    }
}
