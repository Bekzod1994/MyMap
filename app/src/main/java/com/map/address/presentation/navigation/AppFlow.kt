package com.map.address.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.map.address.presentation.main.MainScreen

@Composable
fun AppFlow() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(Color.White, darkIcons = true)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        NavHost(
            navController = navController,
            startDestination = "dashboard"
        ) {
            composable("dashboard") { MainScreen() }
        }
    }
}