package com.map.address.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Color.Gray,
    secondary = Color.White,
    tertiary = Color.DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = Color.Gray,
    secondary = Color.White,
    tertiary = Color.DarkGray

)

@Composable
fun MapAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    rememberSystemUiController().setStatusBarColor(Color.White)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}