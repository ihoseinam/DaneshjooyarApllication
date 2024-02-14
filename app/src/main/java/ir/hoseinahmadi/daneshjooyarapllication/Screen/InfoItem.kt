package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

@Composable
fun InfoItem(navController: NavHostController, data: String) {
    val gson = Gson()
    val dataitem = gson.fromJson(data, DataProduct::class.java)
    Scaffold(
        topBar = { MyTop(navController) },
        bottomBar = {
            MyBottomBar(data = dataitem)
        },
        floatingActionButton = {}
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it),
        ) {

            item {
                infoPack(dataitem)
            }
            item {
                Text(
                    text = "قراره تو این دوره چی یاد بگیرم؟",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = myFont,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )
            }
            itemsIndexed(dataitem.info) { index, item ->
                chiYad(text = item)
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(dancolor)
                        .wrapContentHeight()
                        .padding(5.dp)
                ) {
                    Text(
                        text = "درباره این پکیج آموزشی",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF505A94))
                            .padding(5.dp),
                        textAlign = TextAlign.End,
                        fontFamily = myFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                        text = dataitem.more, textAlign = TextAlign.End,
                        fontFamily = myFont,
                        color = Color.White
                    )
                }
            }
        }


    }
}


@Composable
fun MyTop(navController: NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "مشخصات محصول", fontFamily = myFont,
                fontSize = 20.sp,
                color = Color.Black
            )
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.ArrowForward, contentDescription = "",
                    tint = Color.Black
                )
            }

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Color(0x0C6B6969))
        )
    }


}

@Composable
fun MyBottomBar(data: DataProduct) {
    BottomAppBar(
        containerColor = Color.White,
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.CenterVertically),
        tonalElevation = 15.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val priceortakh = darsadfun(data.priceOr, data.darsad)
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.toman), contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = priceortakh,
                    fontSize = 20.sp,
                    fontFamily = myFont,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff08c056),
                    contentColor = Color.White,
                ),
                modifier = Modifier.padding(end = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "افزودن به سبد خرید",
                    fontFamily = myFont,
                    fontSize = 17.sp,
                    color = Color.White
                )
            }

        }
    }
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

@Composable
fun chiYad(text: String) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 7.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontFamily = myFont
            )
            Spacer(modifier = Modifier.width(3.dp))
            Icon(
                Icons.Default.CheckCircle, contentDescription = "",
                tint = dancolor,
                modifier = Modifier.size(30.dp)
            )

        }
    }
}

@Composable
fun infoPack(data: DataProduct) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp)
            .background(dancolor),
        verticalArrangement = Arrangement.Center
    ) {
            val e =data.videoUrl
            VideoPlayerExo(videoUrl = e)

        Text(
            text = data.title,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            fontFamily = myFont,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = data.nameTicher,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            fontFamily = myFont,
            modifier = Modifier
                .padding(end = 8.dp)
                .fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF5365C2)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = " ${data.Houre} :ساعت",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
            Text(
                text = " ${data.jalase}:جلسه",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
            Text(
                text = "${data.student} :دانشجو ",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = myFont,
            )
        }
    }
}
