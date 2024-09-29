package ir.mobilemaster.newscompose.presentation.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import ir.mobilemaster.newscompose.ui.theme.NewsComposeTheme

class ChatActivity : ComponentActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[ChatViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = viewModel.state.value
            NewsComposeTheme {
                Surface() {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeContentPadding(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        ) {
                            items(state.messages.size) {
                                Box(
                                    modifier = Modifier

                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .shadow(
                                            elevation = 12.dp,
                                            spotColor = Color.Blue,
                                            ambientColor = Color.Blue,
                                        )
                                        .border(1.dp, Color.Blue, shape = RoundedCornerShape(8.dp))
                                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                                        .padding(8.dp)

                                ) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = state.messages[it],
                                        style = TextStyle(
                                            textDirection = TextDirection.Rtl,
                                            fontWeight = FontWeight.ExtraBold
                                        )
                                    )
                                }

                            }
                        }
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = state.message,
                            onValueChange = { viewModel.onMessageChange(it) },
                            label = { Text(text = "Enter your message") },
                            textStyle = TextStyle(
                                textDirection = TextDirection.Rtl,
                                fontWeight = FontWeight.ExtraBold
                            ),
                            trailingIcon = {
                                Icon(
                                    Icons.AutoMirrored.Sharp.Send,
                                    contentDescription = null,
                                    modifier = Modifier.clickable {
                                        viewModel.onSendMessage()
                                    }
                                )
                            }
                        )
                    }
                }

            }
        }
    }
}
