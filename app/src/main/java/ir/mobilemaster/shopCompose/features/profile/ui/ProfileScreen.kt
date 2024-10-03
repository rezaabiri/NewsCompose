package ir.mobilemaster.shopCompose.features.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import ir.mobilemaster.shopCompose.core.theme.AppThemes.textMedium
import ir.mobilemaster.shopCompose.core.theme.AppThemes.textRegular

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(80.dp)
                .shadow(8.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(color = Color.Green)

        ) {
            Text(text = "Profile")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .shadow(8.dp, shape = RoundedCornerShape(12.dp))
        ) {

        }


        CompositionLocalProvider(value = LocalLayoutDirection provides LayoutDirection.Rtl) {
            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = text,
                onValueChange = { text = it },
                label = {
                    Text(
                        "نام و نام خانوادگی",
                        style = textRegular,
                    )
                },
                textStyle = textMedium,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Blue,
                    focusedLabelColor = Color.Blue
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}