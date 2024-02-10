package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.tala
import kotlinx.coroutines.delay
import org.w3c.dom.Text
val eeeee = mutableStateOf(1)

@SuppressLint("UnrememberedMutableState")
@Composable
fun PackGold(navController: NavHostController) {

    var select by remember {
        eeeee
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = select,
            contentColor = Color.Black,
            containerColor = Color.White,
        )
        {
            Tab(
                selected = true,
                text = {
                    Text(
                        text = "اساتید طلایی",
                        fontFamily = myFont
                    )
                },
                onClick = {
                    pack.value = false
                    ticher.value = true
                    eeeee.value = 0
                },
                icon = {
                    if (ticher.value) {
                        Icon(Icons.Filled.Face, contentDescription = "")
                    } else {
                        Icon(Icons.Outlined.Face, contentDescription = "")
                    }
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Blue,
            )
            Tab(
                selected = true,
                text = {
                    Text(
                        text = "دوره های طلایی",
                        fontFamily = myFont
                    )
                },
                onClick = {
                    pack.value = true
                    ticher.value = false
                    eeeee.value =1
                },
                icon = {
                    if (pack.value) {
                        Icon(Icons.Filled.Email, contentDescription = "")
                    } else {
                        Icon(Icons.Outlined.Email, contentDescription = "")

                    }
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Blue,
            )

        }
        val item = arrayOf(
            DataProduct(
                1,
                "جامع ترین دوره آموزش برنامه نویسی اندروید (کاتلین، فلاتر و جاوا)",
                "علیرضا احمدی",
                R.drawable.androidgold,
                125000,
                50,
                0, 0, 0,
                arrayListOf("")
            ),

            )

        pack(navController = navController, item)

        ticher(navController)

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoldPackItem(navController: NavHostController, data: DataProduct) {
    val datazori = DataProduct(
        data.id,
        data.title,
        data.nameTicher,
        data.img,
        data.priceOr,
        data.darsad,
        data.Houre,
        data.student,
        data.jalase,
        data.info,
    )
    val gson = Gson()
    val itemString = gson.toJson(datazori)
    Card(
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${itemString}")
        },
        border = BorderStroke(1.dp, tala),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 2.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    text = data.title,
                    fontFamily = myFont
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = data.nameTicher, fontFamily = myFont
                )
                Text(
                    text = data.priceOr.toString(), fontFamily = myFont
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.4f)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = data.img),
                    contentDescription = ""
                )
            }
        }
    }

}

var pack = mutableStateOf(true)

@Composable
fun pack(navController: NavHostController, data: Array<DataProduct>) {
    var ll by remember {
        pack
    }
    if (ll) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            itemsIndexed(data) { index: Int, item: DataProduct ->
                GoldPackItem(navController, item)
            }

        }
    }
}

var ticher = mutableStateOf(false)

@Composable
fun ticher(navController: NavHostController) {
    var bb by remember {
        ticher
    }
    if (bb) {
        Column {
            Text(text = "dhudfh")
        }
    }

}
