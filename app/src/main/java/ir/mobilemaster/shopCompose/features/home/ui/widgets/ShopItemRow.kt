package ir.mobilemaster.shopCompose.features.home.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.mobilemaster.shopCompose.features.home.data.models.ShopModel

@Composable
fun ProductItemRow(productItem: ShopModel, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        .shadow(8.dp, shape = RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color.White)
        .clickable { onClick() }
        .padding(16.dp)) {
        AsyncImage(
            model = productItem.image,
            contentDescription = "Translated description of what the image contains",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(text = productItem.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productItem.description,
                style = TextStyle(fontSize = 12.sp, color = Color.Gray, lineHeight = TextUnit(16f, TextUnitType.Sp)),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }

    }
}
