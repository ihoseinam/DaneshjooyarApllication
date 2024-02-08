package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        LazyColumn(modifier = Modifier.fillMaxSize(), state = rememberLazyListState()) {
            item { MySlider() }
            item {
                val item = arrayOf(
                    DataProduct(
                        1,
                        stringResource(id = R.string.androidTitle),
                        "علیرضا احمدی",
                        R.drawable.androidgold,
                        6900000,
                        60,
                        arrayListOf(
                            stringResource(id = R.string.an1),
                            stringResource(id = R.string.an2),
                            stringResource(id = R.string.an3),
                            stringResource(id = R.string.an4),
                            stringResource(id = R.string.an5),
                            stringResource(id = R.string.an6),
                            stringResource(id = R.string.an7),
                        )
                    ),
                    DataProduct(
                        2,
                        stringResource(id = R.string.afzoneTitle),
                        "حامد مودی",
                        R.drawable.word,
                        499000,
                        10,
                        arrayListOf(

                        )
                    ),

                    )
                TopProduct(
                    text = "محبوب ترین ها",
                    navController,
                    Screen.PackGold.route,
                    Screen.Home.route
                )
                LazyRow(
                    reverseLayout = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .wrapContentHeight()
                ) {
                    itemsIndexed(item) { index: Int, item: DataProduct ->
                        ItemProduct(data = item, navController)
                    }
                }

            }

            item {
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    state = rememberLazyListState(),
                    reverseLayout = true,
                    modifier = Modifier
                        .background(dancolor)
                        .fillMaxWidth()
                        .padding(15.dp)
                        .wrapContentHeight()
                ) {
                    item { AmazingStart() }
                    item { AmazingEnd(navController, Screen.PackGold.route, Screen.Home.route) }
                }
            }
            item {
                Text(text = "djofhsfdhfcdhf")
            }
        }


    }
}

@Composable
fun AmazingStart() {
    Column(
        modifier = Modifier
            .width(200.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            painter = painterResource(id = R.drawable.amazings), contentDescription = ""
        )
        Spacer(modifier = Modifier.height(15.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp),
            painter = painterResource(id = R.drawable.box), contentDescription = ""
        )
    }
}

@Composable
fun AmazingEnd(navController: NavHostController, route1: String, route2: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .width(180.dp)
            .height(300.dp)
            .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                border = BorderStroke(1.5.dp, Color.Red),
                color = Color.White
            ) {
                IconButton(onClick = {
                    navController.navigate(route1) {
                        popUpTo(route2) {
                            inclusive = true
                        }
                    }
                }) {
                    Icon(
                        Icons.Default.KeyboardArrowLeft,
                        contentDescription = "",
                        Modifier.size(40.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "مشاهده همه",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = myFont
            )
        }
    }
}

@Composable
fun MyTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(20.dp),
            placeholder = {
                Text(
                    text = "جستجو کنید"
                )
            })
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Person, contentDescription = "", Modifier.size(70.dp))
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MySlider(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
    )
    val pagerState = com.google.accompanist.pager.rememberPagerState(
        pageCount =
        images.size
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier.wrapContentSize()) {
            com.google.accompanist.pager.HorizontalPager(
                state = pagerState,
                modifier
                    .wrapContentSize()
            ) { currentPage ->
                Card(
                    modifier
                        .wrapContentSize()
                        .padding(10.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = images[currentPage]),
                        contentDescription = ""
                    )
                }
            }
            IconButton(
                onClick = {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < images.size) {
                        scope.launch {
                            pagerState.scrollToPage(nextPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterEnd)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray
                )
            }
            IconButton(
                onClick = {
                    val prevPage = pagerState.currentPage - 1
                    if (prevPage >= 0) {
                        scope.launch {
                            pagerState.scrollToPage(prevPage)
                        }
                    }
                },
                modifier
                    .padding(30.dp)
                    .size(48.dp)
                    .align(Alignment.CenterStart)
                    .clip(CircleShape),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0x52373737)
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "",
                    modifier.fillMaxSize(),
                    tint = Color.LightGray
                )

            }


        }

    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xff373737) else Color(0xA8373737))
    )
}

@Composable
fun TopProduct(text: String, navController: NavHostController, route1: String, route2: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(0.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.KeyboardArrowLeft,
                contentDescription = "",
                Modifier.align(Alignment.CenterVertically)
            )
            TextButton(onClick = {
                navController.navigate(route1) {
                    popUpTo(route2) {
                        inclusive = true
                    }
                }
            }) {
                Text(
                    text = "مشاهده همه",
                    fontSize = 16.sp,
                    fontFamily = myFont
                )

            }
        }
        Text(
            modifier = Modifier
                .weight(0.5f)
                .padding(end = 8.dp),
            text = text,
            fontSize = 24.sp,
            textAlign = TextAlign.End,
            fontFamily = myFont
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemProduct(data: DataProduct, navController: NavHostController) {
    val zori = DataProduct(
        data.id,
        data.title,
        data.nameTicher,
        data.img,
        data.priceOr,
        data.darsad,
        data.info
    )
    val gson = Gson()
    val itemstring = gson.toJson(zori)
    val priceortakh = darsadfun(data.priceOr, data.darsad)

    Card(
        onClick = {
            navController.navigate(
                route = Screen.InfoItemScreen.route + "?data=${itemstring}"
            )
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(15.dp),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(id = data.img),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(3.dp),
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 6.dp), contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "${data.darsad} %",
                        modifier = Modifier
                            .width(40.dp)
                            .height(24.dp)
                            .background(
                                Color(0xfff32e2e),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = myFont,
                        fontSize = 15.sp
                    )
                }
            }

            Column(modifier = Modifier.weight(0.4f)) {
                Text(
                    text = data.title,
                    textAlign = TextAlign.End,
                    fontSize = 16.sp,
                    fontFamily = myFont

                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = priceortakh.toString(),
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        fontFamily = myFont,
                    )
                    Text(
                        text = data.nameTicher,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 4.dp),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp,
                        fontFamily = myFont,

                        )
                }
                val zori = String.format("%,d", data.priceOr)
                Text(
                    text = zori,
                    modifier = Modifier
                        .padding(start = 4.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 10.sp,
                    fontFamily = myFont,
                    textDecoration = TextDecoration.LineThrough
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


