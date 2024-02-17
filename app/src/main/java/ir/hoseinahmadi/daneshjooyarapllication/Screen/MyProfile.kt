package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
val selectedTabProfile =  mutableIntStateOf(3)
@Composable
fun MyProfileScreen(navController: NavHostController) {
    var selectedTabIndex by remember {
        selectedTabProfile
    }
    val tabTitle = listOf(
        "علاقه مندی",
        "لایسنس ها",
        "دوره ها",
        "پروفایل",
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp)
                .background(dancolor)
                .height(130.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "ثبت نام و این گه بازیا", fontFamily = myFont, fontWeight = FontWeight.Bold, color = Color.White)
        }
        TabRow(
            contentColor = Color.Black,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            },
            modifier = Modifier.padding(horizontal = 3.dp),
            selectedTabIndex = selectedTabIndex
        ) {
            tabTitle.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.DarkGray,
                    text = {
                        Row {
                            Text(text = title,
                                fontFamily = myFont,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                                )
                        }
                    },
                )

            }

        }

        when(selectedTabIndex){
            0-> Love()
            1-> Licence()
            2-> Pack()
            3-> Profile()
        }
    }
}
@Composable
fun Profile(){
    Text(text = "Profile")
}
@Composable
fun Pack(){
    Text(text = "Pack")

}
@Composable
fun Licence(){
    Text(text = "Licence")

}
@Composable
fun Love(){
    Text(text = "Love")
}