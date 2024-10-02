package ir.mobilemaster.shopCompose.features.home.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.mobilemaster.shopCompose.features.home.viewmodel.ShopViewModel

@Composable
fun NewsDetailScreen(viewModel: ShopViewModel, newsId: Int) {
    LaunchedEffect(newsId) {
        viewModel.fetchProductDetails(newsId)
    }

    val newsDetails by viewModel.selectedNews.collectAsState()

    newsDetails?.let { newsItem ->
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = newsItem.image,
                contentDescription = "Translated description of what the image contains",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.title, modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = newsItem.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
