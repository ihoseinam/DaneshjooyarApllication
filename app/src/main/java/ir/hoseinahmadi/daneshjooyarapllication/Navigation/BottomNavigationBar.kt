package ir.hoseinahmadi.daneshjooyarapllication.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveViewModel
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopViewModel
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ShopViewModel = hiltViewModel(),
    viewMode2: FaveViewModel = hiltViewModel()
) {
    val item = listOf(
        BottomNavItem(
            name = "حساب من",
            route = Screen.MyProfile.route,
            selectedIcon = Icons.Filled.Person,
            deselectedIcon = Icons.Outlined.Person,
        ),
        BottomNavItem(
            name = " ویژه",
            route = Screen.PackGold.route,
            selectedIcon = Icons.Filled.Star,
            deselectedIcon = Icons.Outlined.Star,
        ),
        BottomNavItem(
            name = "سبد خرید",
            route = Screen.ShopingCard.route,
            selectedIcon = Icons.Filled.ShoppingCart,
            deselectedIcon = Icons.Outlined.ShoppingCart,
        ),
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = Icons.Filled.Home,
            deselectedIcon = Icons.Outlined.Home,
        ),
    )
    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in item.map { it.route }
    if (showBottomBar) {
        Row {
            NavigationBar(
                modifier = Modifier
                    .background(Color.White)
                    .clip(RoundedCornerShape(15.dp)),
                tonalElevation = 15.dp,
                containerColor = Color(0xFFFFFFFF),
            ) {
                val cartCount = viewModel.getProductCount.collectAsState(0)
                val num = viewMode2.getProductCount.collectAsState(0)
                item.forEachIndexed { index, item ->

                    val selected = item.route == backStackEntry.value?.destination?.route
                    NavigationBarItem(
                        selected = selected,
                        onClick = { onItemClick(item) },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedIconColor = Color(0xFF000000),
                            unselectedTextColor = Color(0xFF000000),
                            selectedIconColor = Color(0xFFFFFFFF),
                            selectedTextColor = dancolor,
                            indicatorColor = dancolor
                        ),
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (index == 2 && cartCount.value > 0) {
                                        Badge(
                                            contentColor = Color.White,
                                            containerColor = Color.Red,
                                        ) {
                                            Text(
                                                text = cartCount.value.toString(),
                                                fontFamily = myFont,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                    if (index == 0 && num.value > 0) {
                                        Badge(
                                            contentColor = Color.White,
                                            containerColor = Color.Red,
                                        ) {
                                            Text(
                                                text = num.value.toString(),
                                                fontFamily = myFont,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                },
                            ) {
                                if (selected) {
                                    Icon(item.selectedIcon, contentDescription = "")
                                } else {
                                    Icon(item.deselectedIcon, contentDescription = "")
                                }
                            }

                        },
                        label = {
                            Text(
                                text = item.name,
                                fontFamily = myFont,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        alwaysShowLabel = selected
                    )
                }
            }
        }
    }
}
