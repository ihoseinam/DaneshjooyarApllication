package ir.hoseinahmadi.daneshjooyarapllication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.BottomNavigationBar
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.SetUpNavGraph
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            Scaffold(
                topBar = {},
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route) {
                                popUpTo(0) {
                                    inclusive = true
                                }
                            }
                        }, modifier = Modifier.background(Color.White)
                    )
                },
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


