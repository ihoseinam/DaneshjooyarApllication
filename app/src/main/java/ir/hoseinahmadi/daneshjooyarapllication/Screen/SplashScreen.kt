package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.component.Loading3Dot
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(500)
        navController.navigate(Screen.Home.route){
            popUpTo(Screen.Splash.route){
                inclusive =true
            }
        }
    }
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(bottom = 75.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier
                .size(250.dp)
                .background(Color.White),
            painter = painterResource(id = R.drawable.logotype),
            contentDescription = "",
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {


        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding( 12.dp),
            contentAlignment = Alignment.BottomCenter

        ) {
            Loading3Dot()

        }
    }
}