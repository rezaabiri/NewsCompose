package ir.mobilemaster.newscompose.presentation.card

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Publisher(
    @DrawableRes val avatar: Int,
    val name: String,
    val job: String
)

@Composable
fun CardWidget(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    description: String,
    publisher: Publisher,
) {
    var showFullText by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = expanded, label = "transition")
    val infiniteTransition = rememberInfiniteTransition()


    val size by transition.animateDp(
        label = "size",
        transitionSpec = { tween(durationMillis = 1000) }) { state ->
        if (state) 400.dp else 300.dp
    }

    val color by transition.animateColor(
        label = "color",
        transitionSpec = { tween(durationMillis = 3000) }) { state ->
        if (state) Color.White else Color.Black
    }

    val color2 by infiniteTransition.animateColor(
        initialValue = Color.White,
        targetValue = Color.Black,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000), // مدت زمان برای هر تغییر رنگ
            repeatMode = RepeatMode.Reverse // بازگشت به حالت اولیه (یعنی از سفید به سیاه و بالعکس)
        ), label = "inf"
    )
    val pulseSize1 by infiniteTransition.animateFloat(
        initialValue = 300f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // مدت زمان هر چرخه انیمیشن: 1 ثانیه
                easing = androidx.compose.animation.core.EaseInOut
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "pluse"
    )

    val pulseSize by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // مدت زمان هر چرخه انیمیشن: 1 ثانیه
                easing = androidx.compose.animation.core.EaseInOut
            ),
            repeatMode = RepeatMode.Reverse
        ), label = "pluse"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.8f)
            .clickable { expanded = !expanded }
            .scale(pulseSize)
            .size(pulseSize1.dp),
        colors = CardDefaults.cardColors(
            containerColor = color2
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),

        ) {
        Column {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.End) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textDirection = TextDirection.Rtl,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .animateContentSize()
                        .clip(RectangleShape)
                        .clickable {
                            showFullText = !showFullText
                        },
                    text = description,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        textDirection = TextDirection.Rtl,
                    ),
                    maxLines = if (showFullText) 100 else 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                        Text(
                            text = publisher.name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                textDirection = TextDirection.Rtl
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = publisher.job,
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 14.sp,
                                textDirection = TextDirection.Rtl
                            )
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = publisher.avatar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }

    }
}

