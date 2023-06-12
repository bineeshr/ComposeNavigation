package com.example.mygoalapp.navigation

import androidx.annotation.DrawableRes
import com.example.mygoalapp.R
import com.example.mygoalapp.navigation.Routes.ROUTE_HOME
import com.example.mygoalapp.navigation.Routes.ROUTE_SETTINGS
import com.example.mygoalapp.navigation.Routes.ROUTE_SPLASH
import com.example.mygoalapp.navigation.Routes.ROUTE_WELCOME
import com.example.mygoalapp.navigation.Routes.fullScreenRoutes

object Routes {
    const val ROUTE_SPLASH = "ROUTE_SPLASH"
    const val ROUTE_WELCOME = "ROUTE_WELCOME"
    const val ROUTE_HOME = "ROUTE_HOME"
    const val ROUTE_SETTINGS = "ROUTE_SETTINGS"

    val fullScreenRoutes = listOf(
        ROUTE_SPLASH
    )
}

sealed class Screen(
    val route: String,
    val title: String = "",
    @DrawableRes val icon: Int = 0
) {

    object Welcome : Screen(route = ROUTE_WELCOME)

    object Splash : Screen(route = ROUTE_SPLASH)

    object Home : Screen(route = ROUTE_HOME, title = "H0ME", icon = R.drawable.ic_home_filled)


    object Settings : Screen(route = ROUTE_SETTINGS,title = "Settings", icon = R.drawable.ic_settings)


    companion object {
        fun isFullScreen(route: String?): Boolean {
            return fullScreenRoutes.contains(route)
        }
    }

}

