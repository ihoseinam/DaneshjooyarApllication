package ir.hoseinahmadi.daneshjooyarapllication.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.hoseinahmadi.daneshjooyarapllication.Screen.HomeScreen
import ir.hoseinahmadi.daneshjooyarapllication.Screen.InfoItem
import ir.hoseinahmadi.daneshjooyarapllication.Screen.MyProfileScreen
import ir.hoseinahmadi.daneshjooyarapllication.Screen.PackGold
import ir.hoseinahmadi.daneshjooyarapllication.Screen.ShopingCard
import ir.hoseinahmadi.daneshjooyarapllication.Screen.SplashScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.PackGold.route)
        {
            PackGold(navController = navController)
        }

        composable(route = Screen.InfoItemScreen.route
                + "?data={data}",
            arguments = listOf(
                navArgument("data") {
                    type = NavType.StringType
                }
            )
        ) {

            InfoItem(
                navController = navController,
                data = it.arguments?.getString("data").toString()
            )
        }
        composable(route = Screen.ShopingCard.route) {
            ShopingCard(navController = navController)
        }
        composable(Screen.MyProfile.route) {
            MyProfileScreen(navController = navController)
        }
    }


}