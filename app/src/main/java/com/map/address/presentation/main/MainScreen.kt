package com.map.address.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.map.address.presentation.main.map.MapScreen
import com.map.address.presentation.main.profile.ProfileScreen
import com.map.address.presentation.main.address.AddressScreen
import com.map.address.presentation.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var isBottomVisible by rememberSaveable { mutableStateOf(true) }

    Scaffold(
        contentColor = Color.White,
        containerColor = Color.White,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomBar(navController, isBottomVisible)
        },

    ) { innerPadding ->

        NavHost(
            navController,
            startDestination = Screen.Address.route,
            modifier = Modifier.padding(innerPadding),
            enterTransition = { fadeIn(tween(100)) },
            exitTransition = { fadeOut(tween(100)) }
        ) {
            composable(Screen.Address.route) { AddressScreen() }
            composable(Screen.Map.route) { MapScreen(
                showBottomSheet = { isBottomVisible = it }
            )
            }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}

@Composable
private fun BottomBar(navController: NavHostController, isBottomVisible: Boolean) {
    AnimatedVisibility(visible = isBottomVisible, enter = fadeIn(tween(0)), exit = fadeOut(tween(0))) {
        Surface(
            shadowElevation = 16.dp,
            shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)
        ) {
            BottomAppBar(containerColor = Color.White, contentColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->

                    NavigationBarItem(
                        modifier = Modifier.clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource(),
                            onClick = {}
                        ),
                        icon = {
                            Image(
                                painter = painterResource(id = screen.iconId),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(
                                    color = if (screen.route != navController.currentDestination?.route) Color.Gray
                                    else Color.Black
                                )
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            selectedTextColor = Color.Black,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.White
                        ),
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            if (screen.route != navController.currentDestination?.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

private val items = listOf(
    Screen.Address,
    Screen.Map,
    Screen.Profile
)