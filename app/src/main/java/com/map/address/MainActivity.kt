package com.map.address

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.yandex.mapkit.MapKitFactory
import com.map.address.presentation.navigation.AppFlow
import com.map.address.presentation.theme.MapAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        MapKitFactory.setApiKey("522fb9ba-acc3-4c2a-ad64-371448cace44")
        MapKitFactory.initialize(this)

        setContent {
            MapAppTheme {
                AppFlow()
            }
        }
    }
}