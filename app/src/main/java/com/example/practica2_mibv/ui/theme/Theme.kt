package com.example.practica2_mibv.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PinkDark,
    onPrimary = Color.White,
    secondary = GrayPrimary,
    background = DarkBackground,
    surface = DarkBackground,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = PinkPrimary,
    onPrimary = TextDark,
    secondary = GrayPrimary,
    background = BackgroundLight,
    surface = BackgroundLight,
    onSurface = TextDark
)

@Composable
fun Practica2_MIBVTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}