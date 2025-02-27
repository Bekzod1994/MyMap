package com.map.address.presentation.navigation

import androidx.annotation.DrawableRes
import com.map.address.R

sealed class Screen(
    val route: String,
    @DrawableRes val iconId: Int
) {
    data object Address : Screen("saved", R.drawable.ic_saved)
    data object Map : Screen("mapScreen", R.drawable.ic_location)
    data object Profile : Screen("profileScreen", R.drawable.ic_profile)
}