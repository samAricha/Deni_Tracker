package teka.android.denitracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import teka.android.denitracker.R

// Set of Material typography styles to start with
val ReemKufi = FontFamily(Font(R.font.reemkufi))
val ReemKufiMedium = FontFamily(Font(R.font.reem_kufi_medium))
val ReemKufiSemiBold = FontFamily(Font(R.font.reem_kufi_semi_bold))
val ReemKufiBold = FontFamily(Font(R.font.reem_kufi_bold))
val Poppins = FontFamily(Font(R.font.poppins))
val PoppinsLight = FontFamily(Font(R.font.poppins_light))

// Set of Material typography styles to start with
val Typography = Typography(
    displayMedium = TextStyle(fontFamily = ReemKufi),
    bodyLarge = TextStyle(
        fontFamily = ReemKufi,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PoppinsLight,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )*/

)