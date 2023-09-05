package com.bima.movieapp.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun NavigationRailLayout(
    navController: NavHostController,
    items : List<Screen>
) {
    val currentRoute = currentRoute(navController = navController)
    NavigationRail {
        items.forEach {screen ->
            NavigationRailItem(
                selected = currentRoute == screen.route,
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.name) },
                label = { Text(text = screen.name) },
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

