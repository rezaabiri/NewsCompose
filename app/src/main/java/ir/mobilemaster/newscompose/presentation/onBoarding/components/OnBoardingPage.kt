package ir.mobilemaster.newscompose.presentation.onBoarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.mobilemaster.newscompose.presentation.onBoarding.Page
import ir.mobilemaster.newscompose.presentation.onBoarding.pages
import ir.mobilemaster.newscompose.ui.theme.NewsComposeTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = TextStyle(fontSize = 12.sp)
        )
    }
}
