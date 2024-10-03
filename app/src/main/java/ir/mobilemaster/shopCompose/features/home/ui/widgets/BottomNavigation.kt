package ir.mobilemaster.shopCompose.features.home.ui.widgets

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ir.mobilemaster.shopCompose.features.profile.ui.ProfileScreen

@Composable
fun BottomNavigation(modifier: Modifier = Modifier, navController: NavController) {

    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(70.dp)
            .shadow(10.dp, shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(8.dp)
            .clickable(indication = null, interactionSource = null) { },
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        NavigationItem("Home", imageVector = Icons.Default.Home, onClick = {})
        NavigationItem("Bookmark", imageVector = Icons.Default.Favorite, onClick = {})
        NavigationItem("Profile", imageVector = Icons.Default.Person, onClick = {
            navController.navigate("profile")
        })
    }
}

@Composable
fun NavigationItem(title: String, imageVector: ImageVector, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = imageVector, contentDescription = "Home")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title)
    }
}