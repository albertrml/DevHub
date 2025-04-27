package br.com.arml.devhub.ui.theme


import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Gray300,
    onPrimary = Gray900,
    primaryContainer = Gray500,
    onPrimaryContainer = Gray100,

    secondary = Gray400,
    onSecondary = Gray900,
    secondaryContainer = Gray600,
    onSecondaryContainer = Gray100,

    background = Gray900,
    onBackground = Gray100,

    surface = Gray800,
    onSurface = Gray100,
    surfaceVariant = Gray700,
    onSurfaceVariant = Gray100,

    error = Red300,
    onError = Gray900,

    outline = Gray600
)

private val LightColorScheme = lightColorScheme(
    primary = Gray700,
    onPrimary = Gray100,
    primaryContainer = Gray500,
    onPrimaryContainer = Gray100,

    secondary = Gray500,
    onSecondary = Gray100,
    secondaryContainer = Gray400,
    onSecondaryContainer = Gray900,

    background = Gray100,
    onBackground = Gray900,

    surface = Gray200,
    onSurface = Gray900,
    surfaceVariant = Gray300,
    onSurfaceVariant = Gray900,

    error = Red800,
    onError = Gray100,

    outline = Gray400
)

@Composable
fun DevHubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}