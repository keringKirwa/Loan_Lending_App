package com.example.kkdev_hustler_fund_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = MyColors.Orange,
    secondary = MyColors.LightBlue,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = MyColors.LightBlue,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun Kkdev_Hustler_Fund_AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = LightColorScheme
    ChangeSystemBarsColor()

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}


@Composable
fun ChangeSystemBarsColor() {
    val statusBarsColor = PrimaryColor

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = statusBarsColor,
            darkIcons = false
        )
        systemUiController.setNavigationBarColor(Color.White, darkIcons = false)
    }
}






