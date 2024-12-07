package com.example.androidtest.ui.activity

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidtest.data.model.CarModel
import com.example.androidtest.ui.screens.CarDetailScreen
import com.example.androidtest.ui.screens.CarsScreen
import com.example.androidtest.ui.screens.Screens
import com.example.androidtest.ui.theme.AndroidTestTheme
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTestTheme {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {
    val navController = rememberNavController()

    Scaffold(topBar = { TopBar() }) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screens.CarsScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.CarsScreen.route) {
                CarsScreen { selectedCar ->
                    val jsonCar = Uri.encode(Json.encodeToString(selectedCar))
                    navController.navigate("${Screens.CarDetailScreen.route}/$jsonCar")
                }
            }
            composable(
                route = "${Screens.CarDetailScreen.route}/{carJson}",
                arguments = listOf(navArgument("carJson") { type = NavType.StringType })
            ) { backStackEntry ->
                val carJson = backStackEntry.arguments?.getString("carJson")
                val car = carJson?.let { Json.decodeFromString<CarModel>(it) }
                car?.let {
                    CarDetailScreen(car = it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CarsApp",
                fontWeight = FontWeight.Bold
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidTestTheme {
        Content()
    }
}