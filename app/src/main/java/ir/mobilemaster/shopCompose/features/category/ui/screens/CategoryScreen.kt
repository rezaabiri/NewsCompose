package ir.mobilemaster.shopCompose.features.category.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.mobilemaster.shopCompose.features.category.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(viewModel: CategoryViewModel, navController: NavController) {
    LaunchedEffect(Unit) {
        viewModel.fetchProductsList()
    }

    val categoryList by viewModel.categoryList.collectAsState()

    Box () {
        LazyColumn (
            modifier = Modifier.fillMaxHeight(fraction = 1f)
        ) {
            itemsIndexed(categoryList){index, item ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Blue),


                ){
                    Text(text = item,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}