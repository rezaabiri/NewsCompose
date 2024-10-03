package ir.mobilemaster.shopCompose.core.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp
import ir.mobilemaster.shopCompose.R

object AppThemes {
    private val bold = FontFamily(
        Font(R.font.bold),
    )
    private val medium = FontFamily(
        Font(R.font.medium),
    )
    private val regular = FontFamily(
        Font(R.font.regular),
    )

    val textRegular = TextStyle(
        fontSize = 14.sp,
        textDirection = TextDirection.Rtl,
        fontFamily = regular
    )
    val textMedium = TextStyle(
        fontSize = 14.sp,
        textDirection = TextDirection.Rtl,
        fontFamily = medium
    )
    val textBold = TextStyle(
        fontSize = 14.sp,
        textDirection = TextDirection.Rtl,
        fontFamily = bold
    )
}