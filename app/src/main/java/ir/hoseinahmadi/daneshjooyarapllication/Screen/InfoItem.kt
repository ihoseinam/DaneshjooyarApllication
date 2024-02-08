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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    modifier = Modifier.fillMaxWidth()
                )
            }
            itemsIndexed(dataitem.info) { index, item ->
                chiYad(text = item)
            }
            item {


            }
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(navController: NavHostController) {
    TopAppBar(title = {
        Text(text = "مشخصات پیکج", fontFamily = myFont)
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.White,
            scrolledContainerColor = Color.Red,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }
        }
    )
}
@Composable
fun MyBottomBar(data: DataProduct){
    BottomAppBar(
        contentPadding = PaddingValues(12.dp)
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "افزودن به سبد خرید")
        }
        val priceortakh = darsadfun(data.priceOr, data.darsad)
        Text(text = priceortakh)

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
            .fillMaxWidth()
            .padding(2.dp),
        elevation = CardDefaults.cardElevation(13.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = text,
                fontFamily = myFont)
            Icon(Icons.Default.Star, contentDescription = "",
                tint = Color.Blue,
                modifier = Modifier.size(30.dp)
                )

        }
    }
}

@Composable
fun infoPack(data: DataProduct){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(dancolor)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = data.img),
                contentDescription = "",
                modifier = Modifier
                    .size(400.dp, 250.dp)
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxSize(),
            )
        }

        Text(text = data.title,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            fontFamily = myFont,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color(0xFF5365C2)),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = " ۱۴۵ ساعت",
                fontSize = 15.sp,
                color = Color.White,
                fontFamily = myFont,
                )
            Text(text = "۶۴۸ جلسه",
                fontSize = 15.sp,
                color = Color.White,
                fontFamily = myFont,
                )
            Text(text = " ۸۱۵ دانشجو",
                fontSize = 15.sp,
                color = Color.White,
                fontFamily = myFont,
                )
        }
    }
}