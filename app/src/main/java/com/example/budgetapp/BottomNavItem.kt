package com.example.budgetapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector) {
    object Stats : BottomNavItem("통계", Icons.Default.Insights)
    object Home : BottomNavItem("홈", Icons.Default.Home)
    object Settings : BottomNavItem("설정", Icons.Default.Settings)
}

