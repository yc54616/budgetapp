package com.example.budgetapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.budgetapp.BottomNavItem

@Composable
fun BottomNavBar(selected: BottomNavItem, onItemSelected: (BottomNavItem) -> Unit) {
    NavigationBar {
        val items = listOf(
            BottomNavItem.Stats,
            BottomNavItem.Home,
            BottomNavItem.Settings
        )
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selected == item,
                onClick = { onItemSelected(item) }
            )
        }
    }
}