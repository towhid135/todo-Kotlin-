package com.example.todo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColors(
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val borderPrimary: Color,
    val borderSecondary: Color,
    val borderTertiary: Color,
    val buttonPrimary: Color,
    val buttonSecondary: Color,
    val dialogBackgroundPrimary: Color,
    val dialogTextPrimary: Color,
    val error: Color,
    val iconPrimary: Color,
    val iconSecondary: Color,
    val isLightTheme: Boolean,
    val onPrimary: Color,
    val onSecondary: Color,
    val placeHolderPrimary: Color,
    val primary: Color,
    val secondary: Color,
    val success: Color,
    val tertiary: Color,
    val textBackgroundPrimary: Color,
    val textInputBackgroundPrimary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val transparent: Color
)

val darkThemeColors = CustomColors(
    backgroundPrimary = Color(0xFF121212),
    backgroundSecondary = Color(0xFF363636),
    borderPrimary = Color(0xFF8875FF),
    borderSecondary = Color(0xFF979797),
    borderTertiary = Color(0xFFFFFFFF),
    buttonPrimary = Color(0xFF8875FF),
    buttonSecondary = Color(0xFF444444),
    dialogBackgroundPrimary = Color(0xFFFFFFFF),
    dialogTextPrimary = Color(0xFF121212),
    error = Color(0xFFA31D00),
    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFFAFAFAF),
    isLightTheme = false,
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    placeHolderPrimary = Color(0xFF535353),
    primary = Color(0xFF8875FF),
    secondary = Color(0xFF363636),
    success = Color(0xFF07DF27),
    tertiary = Color(0xFF444444),
    textBackgroundPrimary = Color(0xFF535353),
    textInputBackgroundPrimary = Color(0xFF1D1D1D),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFF8687E7),
    textTertiary = Color(0xFF979797),
    transparent = Color(0x00000000)
)

val lightThemeColors = CustomColors(
    backgroundPrimary = Color(0xFF121212),
    backgroundSecondary = Color(0xFF363636),
    borderPrimary = Color(0xFF8875FF),
    borderSecondary = Color(0xFF979797),
    borderTertiary = Color(0xFFFFFFFF),
    buttonPrimary = Color(0xFF8875FF),
    buttonSecondary = Color(0xFF444444),
    dialogBackgroundPrimary = Color(0xFFFFFFFF),
    dialogTextPrimary = Color(0xFF121212),
    error = Color(0xFFA31D00),
    iconPrimary = Color(0xFFFFFFFF),
    iconSecondary = Color(0xFFAFAFAF),
    isLightTheme = true,
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    placeHolderPrimary = Color(0xFF535353),
    primary = Color(0xFF8875FF),
    secondary = Color(0xFF363636),
    success = Color(0xFF07DF27),
    tertiary = Color(0xFF444444),
    textBackgroundPrimary = Color(0xFF535353),
    textInputBackgroundPrimary = Color(0xFF1D1D1D),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFF8687E7),
    textTertiary = Color(0xFF979797),
    transparent = Color(0x00000000)
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