package com.example.todo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val tertiary: Color,
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val buttonPrimary: Color,
    val buttonSecondary:Color,
    val textPrimary: Color,
    val iconPrimary: Color,
    val iconSecondary: Color,
    val textSecondary: Color,
    val placeHolderPrimary: Color,
    val textBackgroundPrimary: Color,
    val textInputBackgroundPrimary: Color,
    val borderPrimary: Color,
    val borderSecondary: Color,
    val error: Color,
    val success: Color,
    val transparent: Color,
    val isLightTheme: Boolean
)

val darkThemeColors = CustomColors(
    primary = Color(0xFF8875FF),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF363636),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF444444),
    backgroundPrimary = Color(0xFF121212),
    backgroundSecondary = Color(0xFF363636),
    buttonPrimary = Color(0xFF8875FF),
    buttonSecondary = Color(0xFF444444),
    textPrimary = Color(0xFFFFFFFF),
    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFFAFAFAF),
    textSecondary = Color(0xFF8687E7),
    placeHolderPrimary = Color(0xFF535353),
    textBackgroundPrimary = Color(0xFF535353),
    textInputBackgroundPrimary = Color(0xFF1D1D1D),
    borderPrimary = Color(0xFF8875FF),
    borderSecondary = Color(0xFF979797),
    error = Color(0xFFA31D00),
    success = Color(0xFF07DF27),
    transparent = Color(0x00000000),
    isLightTheme = false
)

val lightThemeColors = CustomColors(
    primary = Color(0xFF8875FF),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF363636),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF444444),
    backgroundPrimary = Color(0xFF121212),
    backgroundSecondary = Color(0xFF363636),
    buttonPrimary = Color(0xFF8875FF),
    buttonSecondary = Color(0xFF444444),
    textPrimary = Color(0xFFFFFFFF),
    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFFAFAFAF),
    textSecondary = Color(0xFF8687E7),
    placeHolderPrimary = Color(0xFF535353),
    textBackgroundPrimary = Color(0xFF535353),
    textInputBackgroundPrimary = Color(0xFF1D1D1D),
    borderPrimary = Color(0xFF8875FF),
    borderSecondary = Color(0xFF979797),
    error = Color(0xFFA31D00),
    success = Color(0xFF07DF27),
    transparent = Color(0x00000000),
    isLightTheme = true
)


data class CustomTheme(
      val colors: CustomColors = lightThemeColors,
//    val typography: CustomTypography,
//    val shapes: CustomShapes,
//    val dimensions: CustomDimensions
)

val LocalTheme = staticCompositionLocalOf<CustomTheme> {
    error("No theme provided")
}