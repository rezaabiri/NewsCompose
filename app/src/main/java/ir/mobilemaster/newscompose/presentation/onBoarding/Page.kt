package ir.mobilemaster.newscompose.presentation.onBoarding

import androidx.annotation.DrawableRes
import ir.mobilemaster.newscompose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Jetpack Compose",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        R.drawable.onboarding1
    ),
    Page(
        "Jetpack Compose 2",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        R.drawable.onboarding2
    ),
    Page(
        "Jetpack Compose 3",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
        R.drawable.onboarding3
    ),
)