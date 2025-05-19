// AppNavigation.kt
package com.example.budgetapp.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.budgetapp.BottomNavItem
import com.example.budgetapp.ui.components.BottomNavBar
import com.example.budgetapp.ui.screens.*

@Composable
fun AppNavigation() {
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selected = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Crossfade(targetState = selectedItem, label = "TabTransition") { screen ->
                when (screen) {
                    is BottomNavItem.Home -> HomeScreen()
                    is BottomNavItem.Stats -> StatsScreen()
                    is BottomNavItem.Settings -> SettingsScreen()
                }
            }
        }
    }
}
