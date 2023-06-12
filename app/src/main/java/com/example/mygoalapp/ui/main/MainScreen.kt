package com.example.mygoalapp.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mygoalapp.navigation.GoalNavigationGraph
import com.example.mygoalapp.navigation.NavigationBar
import com.example.mygoalapp.navigation.Screen

@Composable
fun MainScreen(onFinish: () -> Unit) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route ?: Screen.Splash.route
    val isFullScreen = Screen.isFullScreen(route)

    if (route == Screen.Home.route) {
        BackHandler() {
            onFinish()
        }
    }

    Scaffold(bottomBar = {
        if (!isFullScreen) {
            NavigationBar(navController)
        }
    }
    ) {
        GoalNavigationGraph(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }
}