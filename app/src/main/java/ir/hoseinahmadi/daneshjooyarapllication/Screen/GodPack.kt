package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.TopTicher
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

val selectedTabGold = mutableStateOf(1)
@SuppressLint("UnrememberedMutableState")
@Composable
fun PackGold(navController: NavHostController) {
    var select by remember {
        selectedTabGold
    }
    val title = listOf(
        "اساتید طلایی",
        "دوره های طلایی"
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = select,
            contentColor = Color.Black,
            containerColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[select])
                        .height(3.dp)
                        .background(dancolor)
                )
            },
            modifier = Modifier.padding(horizontal = 5.dp),
        ) {
            title.forEachIndexed { index, title ->
                Tab(
                    selected = select == index,
                    onClick = { select = index },
                    selectedContentColor = dancolor,
                    unselectedContentColor = Color.DarkGray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                fontFamily = myFont
                            )
                        }
                    },
                )

            }
        }
        when (select) {
            1 -> pack(navController)
            0 -> ticher()
        }


    }


}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun GoldPackItem(navController: NavHostController, data: DataProduct) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${data.id}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
            ) {
                Spacer(modifier = Modifier.height(9.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    text = data.title,
                    fontFamily = myFont
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.nameTicher, fontFamily = myFont,
                    textAlign = TextAlign.End,
                    color = dancolor
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.8.dp)
                        .background(Color(0x0F6B6969))
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.toman), contentDescription = "",
                        Modifier
                            .size(25.dp)
                            .padding(start = 5.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = darsadfun(data.priceOr, data.darsad), fontFamily = myFont,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Red
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(0.4f)
            ) {
                GlideImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .padding(4.dp),
                    contentScale = ContentScale.Fit,
                    model =  data.img,
                    contentDescription = ""
                )
            }


        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopTicherTab(data: TopTicher) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(410.dp)
            .clickable { }
            .padding(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End,
        ) {
            GlideImage(
                modifier = Modifier
                    .width(240.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .height(300.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp),
                model = data.img,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = data.name,
                fontSize = 20.sp,
                fontFamily = myFont,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 6.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.info,
                fontSize = 14.sp,
                fontFamily = myFont,
                color = Color.Black,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(end = 6.dp)
            )

        }
    }
}


@Composable
fun pack(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp)
            .background(Color(0xffd6a927)),
    ) {
        val loveitem = arrayOf(
            DataProduct(
                1,
                "جامع ترین دوره آموزش برنامه نویسی اندروید (کاتلین، فلاتر و جاوا)",
                "علیرضا احمدی",
                "https://www.daneshjooyar.com/wp-content/uploads/2023/08/android-1-min-1-400x225.jpg",
                6900000,
                60,
            ),
            DataProduct(
                2,
                "دوره آموزش افزونه نویسی وردپرس، پلاگین نویسی حرفه ای برای وردپرس",
                "حامد مودی",
                "https://www.daneshjooyar.com/wp-content/uploads/2023/05/wordpress-min-min-400x225.jpg",
                1299000,
                40,
            ),
        )
        itemsIndexed(loveitem) { index, item ->
            GoldPackItem(navController = navController, data = item)
        }
    }

}


@Composable
fun ticher() {
    val topTicher = arrayOf(
        TopTicher(
            1,
            "استاد علیرضا احمدی",
            "https://raw.githubusercontent.com/ihoseinam/video-shop/main/ali.jpg",
            "متخصص برنامه نویسی موبایل "
        ),
        TopTicher(
            2,
            "استاد حامد مودی",
            "https://raw.githubusercontent.com/ihoseinam/video-shop/main/modi.jpg",
            "طراح و کدنویس افزونه و قالب وردپرس "
        ),
        TopTicher(
            1,
            "استاد طاها اهوازی",
            "https://raw.githubusercontent.com/ihoseinam/video-shop/main/taha.jpg",
            "برنامه نویس فول استک موبایل"
        ),
    )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(4.dp),
        content = {
            itemsIndexed(topTicher) { index: Int, item: TopTicher ->
                TopTicherTab(data = item)
            }
        })
}


private fun darsadfun(price: Int, darsad: Int): String {
    return if (darsad > 0) {
        val ee = (price * darsad) / 100
        val b = price - ee
        String.format("%,d", b)
    } else {
        price.toString()
    }
}
