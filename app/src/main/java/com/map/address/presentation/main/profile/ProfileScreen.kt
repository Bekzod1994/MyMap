package com.map.address.presentation.main.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        contentColor = Color.White,
        containerColor = Color.White
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(horizontal = 16.dp)) {
            Text("ProfileScreen", color = Color.Black)
        }
    }
}