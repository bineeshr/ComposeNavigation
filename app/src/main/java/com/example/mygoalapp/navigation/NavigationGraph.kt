package com.example.mygoalapp.navigation

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mygoalapp.ui.home.HomeScreen
import com.example.mygoalapp.ui.settings.SettingScreen
import com.example.mygoalapp.ui.splash.SplashScreen
import com.example.mygoalapp.ui.welcome.WelcomeScreen

@Composable
fun GoalNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val startDestination = remember { mutableStateOf(Screen.Splash.route) }
    LaunchedEffect(key1 = startDestination) {
        if (startDestination.value == Screen.Home.route) {
            navController.navigate(Screen.Home.route)
        }
    }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.value
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen()
        }

        composable(route = Screen.Splash.route, content = {
            SplashScreen {
                startDestination.value = Screen.Home.route
            }
        })

        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Settings.route) {
            SettingScreen()
        }
    }
}