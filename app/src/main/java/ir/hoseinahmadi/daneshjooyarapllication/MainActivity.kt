package ir.hoseinahmadi.daneshjooyarapllication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.BottomNavigationBar
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.SetUpNavGraph

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            Scaffold(
                topBar = {},
                bottomBar = {BottomNavigationBar(navController =navController,
                    onItemClick = {
                    navController.navigate(it.route){
                        popUpTo(0){
                            inclusive =true
                        }
                    }
                })},
            ) {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    SetUpNavGraph(navController = navController)
                }
            }
        }
    }
}
