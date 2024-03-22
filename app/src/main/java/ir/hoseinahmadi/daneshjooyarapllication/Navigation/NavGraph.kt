package ir.hoseinahmadi.daneshjooyarapllication.Navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.hoseinahmadi.daneshjooyarapllication.Screen.AcountScreen
import ir.hoseinahmadi.daneshjooyarapllication.Screen.HomeScreen
import ir.hoseinahmadi.daneshjooyarapllication.Screen.InfoItem
import ir.hoseinahmadi.daneshjooyarapllication.Screen.LoginScreen
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
        composable(route = Screen.InfoItemScreen.route + "?data={data}",
            arguments = listOf(
                navArgument("data") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            InfoItem(
                navController = navController,
                data = it.arguments?.getInt("data", 0)
            )
        }
        composable(route = Screen.ShopingCard.route) {
            ShopingCard(navController = navController)
        }
        composable(Screen.MyProfile.route) {
//            val contex = LocalContext.current
//            val pref2 = contex.getSharedPreferences("checklogin", Context.MODE_PRIVATE)
//            val checkLogin=pref2.getBoolean("login", false)
//            if (!checkLogin){
//                LoginScreen(navHostController = navController)
//            }else {
//                MyProfileScreen(navController = navController)
//            }
            MyProfileScreen(navController = navController)
        }
        composable(Screen.Acount.route) {
            AcountScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navHostController = navController)
        }
    }


}