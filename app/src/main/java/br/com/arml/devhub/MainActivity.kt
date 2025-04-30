package br.com.arml.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.arml.devhub.ui.navigation.DevHubNavigation
import br.com.arml.devhub.ui.theme.DevHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            DevHubTheme {
                DevHubNavigation(
                    modifier = Modifier,
                    navController = navController
                )
            }
        }
    }
}