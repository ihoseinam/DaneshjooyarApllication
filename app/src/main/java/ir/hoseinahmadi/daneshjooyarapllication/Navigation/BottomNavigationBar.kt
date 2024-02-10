package ir.hoseinahmadi.daneshjooyarapllication.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val item = listOf(
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = Icons.Filled.Home,
            deselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavItem(
            name = "سبد خرید",
            route = Screen.ShopingCard.route,
            selectedIcon = Icons.Filled.ShoppingCart,
            deselectedIcon = Icons.Outlined.ShoppingCart,
        ),
        BottomNavItem(
            name = " ویژه",
            route = Screen.PackGold.route,
            selectedIcon = Icons.Filled.Star,
            deselectedIcon = Icons.Outlined.Star,
        ),
        BottomNavItem(
            name = "حساب من",
            route = Screen.MyPack.route,
            selectedIcon = Icons.Filled.Person,
            deselectedIcon = Icons.Outlined.Person,
        ),
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in item.map { it.route }
    if (showBottomBar) {
        NavigationBar(
            modifier = Modifier.background(Color.White) .clip(RoundedCornerShape(15.dp)),
            tonalElevation = 10.dp,
        ) {
            item.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                NavigationBarItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = Color(0xFF8D8B8B),
                        unselectedTextColor = Color(0xFF999898),
                        selectedIconColor = Color(0xFF000000),
                        selectedTextColor = Color(0xFF000000),
                        indicatorColor = Color(0xFFB3C9DC)
                    ),
                    icon = {
                        if (selected) {
                            Icon(item.selectedIcon, contentDescription = "")
                        } else {
                            Icon(item.deselectedIcon, contentDescription = "")
                        }
                    },
                    label = {
                        Text(text = item.name,
                            fontFamily = myFont,
                            )
                    }
                )
            }
        }

    }
}
