package ir.hoseinahmadi.daneshjooyarapllication.Navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name:String,
    val route:String,
    val selectedIcon: ImageVector,
    val deselectedIcon: ImageVector,
    )
