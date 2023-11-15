package ru.kaer.documentsapp.authorizedZone

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.kaer.documentsapp.android.R
import ru.kaer.documentsapp.component.TabBarItem
import ru.kaer.documentsapp.navigation.Screen


@Composable
fun AuthorizedZone() {
    val navController = rememberNavController()
    val items = listOf(
        TabBarItem(
            route = Screen.Main.name,
            icon = R.drawable.ic_search,
        ),
        TabBarItem(
            route = Screen.Notice.name,
            icon = R.drawable.ic_notice
        ),
        TabBarItem(
            route = Screen.Profile.name,
            icon = R.drawable.ic_profile
        ),
    )
    Scaffold(
        containerColor = Color(0xFFCEEDDB),
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
        ,
        contentWindowInsets = WindowInsets.systemBars.only(
            WindowInsetsSides.Horizontal
        ),
        bottomBar = {
            BottomNavigation() {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = null
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
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
                        },
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Main.name,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Main.name){
                Text(text = "MAIN", color = Color.White)
            }
            composable(Screen.Notice.name){
                Text(text = "Notice", color = Color.White)
            }
            composable(Screen.Profile.name){
                Text(text = "Profile", color = Color.White)
            }
        }
    }
}