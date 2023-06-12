package com.example.mygoalapp.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationBar(
    navController: NavHostController,
) {
    val tabs = remember {
        listOf(
            Screen.Home,
            Screen.Settings,
        )
    }

    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.Black,
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        tabs.forEach { item ->
            BottomNavigationItem(icon = {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.title
                )
            }, label = {
                Text(
                    text = item.title,
                    maxLines = 1,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }, selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                })
        }
    }
}