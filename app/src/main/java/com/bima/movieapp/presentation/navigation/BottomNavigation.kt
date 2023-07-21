package com.bima.movieapp.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavHostController,
    items : List<Screen>
) {
    val currentRoute = currentRoute(navController = navController)
    NavigationBar(
        modifier = Modifier.fillMaxHeight(0.12f)
    ) {
        items.forEach {screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.name) },
                label = { Text(text = screen.name)},
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
            )
        }
    }
//    BottomAppBar(
//        contentPadding = 16.dp,
//        actions = {
//            for (i in items.indices) {
//                IconButton(onClick = {
//                    if (currentRoute != items[i].route) navController.navigate(items[i].route)
//                }) {
//                    Column() {
//                        Icon(imageVector = items[i].icon , contentDescription ="navigation icon" )
//                        Text(text = items[i].name)
//                    }
//                }
//            }
//        }
//    )
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}