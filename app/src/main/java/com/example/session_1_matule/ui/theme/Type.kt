package com.example.session_1_matule.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.session_1_matule.R

// Шрифты
val fontFamily = FontFamily(
    Font(
        resId = R.font.new_peninim_mt,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    )
)

// Кастомные стили типографии
object AppTypography {
    val h1 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 32.sp,
        lineHeight = 33.sp,
        fontWeight = FontWeight.Normal
    )

    val body1 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    )

    val body2 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal
    )

    val subtitle1 = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    )

    val caption = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    )

    val button = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    )
}

// Material3 Typography
val Typography = Typography(

    // Заголовок большой
    displayLarge = AppTypography.h1,
    
    // Основной текст
    bodyLarge = AppTypography.body1,
    bodyMedium = AppTypography.body2,
    
    // Подзаголовки
    titleMedium = AppTypography.subtitle1,
    
    // Мелкий текст
    labelSmall = AppTypography.caption,
    
    // Текст кнопок
    labelLarge = AppTypography.button
)