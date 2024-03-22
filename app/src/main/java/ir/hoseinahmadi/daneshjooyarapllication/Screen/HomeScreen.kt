package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.ExperimentalPagerApi
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopViewModel
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.Category
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.TopTicher
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var infoTichstate = mutableStateOf(TopTicher(1, "", "", "", 0, 0, 0))

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(navController: NavHostController, viewModel: ShopViewModel= hiltViewModel()) {
    val scrollState = rememberLazyListState()
    val loli by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex == 0 }
    }

    val drawerstate = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scop = rememberCoroutineScope()
    val contex = LocalContext.current
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.75f),
                drawerContainerColor = Color.White,
            ) {
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 4.dp, vertical = 6.dp)
                ) {
                    val ee = contex.getSharedPreferences("username", Context.MODE_PRIVATE)
                    val p = ee.getString("name", "کاربر")
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "",
                        modifier = Modifier.clip(RoundedCornerShape(23.dp))
                    )
                    Text(
                        text = "سلام ${p} عزیز ",
                        fontFamily = myFont,
                        fontSize = 18.sp,
                        textAlign = TextAlign.End,
                        style = TextStyle(textDirection = TextDirection.Ltr),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(1.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = myFont,
                        text = "اگر نظر یا پینشهادی داری ممنون میشم منو آگاه کنی",
                        textAlign = TextAlign.End,
                        style = TextStyle(textDirection = TextDirection.Ltr),
                        fontSize = 11.sp,
                        color = Color(0xFF676767)
                    )
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Button(
                            shape = RoundedCornerShape(11.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 2.dp),
                            onClick = {
                                opente.value = true
                                scop.launch {
                                    drawerstate.close()
                                    opente.value = false
                                }
                            }) {

                            Text(
                                text = "ارتباط با توسعه دهنده(تلگرام)",
                                fontFamily = myFont,
                                color = Color.White
                            )
                        }
                    }


                }

            }
        },
        drawerState = drawerstate
    ) {
        openTelegram(contex)
        Scaffold(
            containerColor = Color.White,
            floatingActionButton = {
                FloatingActionButton(
                    containerColor = Color.White,
                    shape = CircleShape,
                    onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.posh),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                    )
                }
            },
            topBar = {
                AnimatedVisibility(
                    loli,
                    exit = fadeOut(), enter = slideInVertically() + fadeIn()
                ) {
                    MyTopBarHome(scop, drawerstate)
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(it),
                state = scrollState
            ) {
                item { MySlider() }
                item {
                    TopProduct(text = "جدید ترین ها", R.drawable.new_ic)
                    LazyRow(
                        reverseLayout = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(3.dp)
                            .wrapContentHeight()
                    ) {
                        val newite = arrayOf<DataProduct>(
                            DataProduct(
                                11,
                                "آموزش ساخت خزنده وب با پایتون (خزش در صفحات دیجی کالا)",
                                "علی رستمی",
                                "https://www.daneshjooyar.com/wp-content/uploads/2023/01/python.png",
                                299000,
                                40,
                            ),
                            DataProduct(
                                12,
                                "  دوره آموزش جاوا به همراه ۲۰ تمرین واقعی + آموزش شی گرایی",
                                "طاها اهوازی",
                                "https://www.daneshjooyar.com/wp-content/uploads/2024/01/java-2-min-400x225.jpg",
                                1900000,
                                40,
                            ),
                            DataProduct(
                                13,
                                "آموزش پیاده سازی ۲۰ پروژه جاوا اسکریپتی مناسب بازار کار",
                                "محمد حسین معین",
                                "https://www.daneshjooyar.com/wp-content/uploads/2023/11/js-1-min-400x225.png",
                                299000,
                                40,
                            )
                        )
                        itemsIndexed(newite) { _: Int, item: DataProduct ->
                            ItemProduct(
                                data = item, navController, viewModel
                            )
                        }
                    }

                }
                item {
                    CategoryHome()
                }
                item {
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically,
                        state = rememberLazyListState(),
                        reverseLayout = true,
                        modifier = Modifier
                            .background(Color(0xffd6a927))
                            .fillMaxWidth()
                            .padding(vertical = 15.dp)
                            .wrapContentHeight()
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
                            )
                        )

                        item { AmazingStart() }
                        itemsIndexed(loveitem) { _, item ->
                            AmazingItem(navController = navController, data = item)
                        }
                        item {
                            AmazingEnd(navController, Screen.PackGold.route, Screen.Home.route)
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    TopProduct(text = "محبوب ترین ها", R.drawable.love_ic)
                    LazyRow(
                        reverseLayout = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(3.dp)
                            .wrapContentHeight()
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
                        itemsIndexed(loveitem) { _: Int, item: DataProduct ->
                            ItemProduct(
                                data = item, navController, viewModel
                            )
                        }
                    }
                }
                item {
                    var addInfo by remember { infoTichstate }
                    infoTicher(
                        name = addInfo.name,
                        img = addInfo.img,
                        info = addInfo.info,
                        addInfo.numd,
                        addInfo.daneshjo,
                        addInfo.houre
                    )
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically,
                        state = rememberLazyListState(),
                        reverseLayout = true,
                        modifier = Modifier
                            .background(dancolor)
                            .fillMaxWidth()
                            .padding(vertical = 15.dp)
                            .wrapContentHeight()
                    ) {
                        item { AmazingTicher() }
                        val topTicher = arrayOf(
                            TopTicher(
                                1,
                                "استاد علیرضا احمدی",
                                "https://raw.githubusercontent.com/ihoseinam/video-shop/main/ali.jpg",
                                "متخصص برنامه نویسی موبایل ",
                                22,
                                53255,
                                639
                            ),
                            TopTicher(
                                2,
                                "استاد حامد مودی",
                                "https://raw.githubusercontent.com/ihoseinam/video-shop/main/modi.jpg",
                                "طراح و کدنویس افزونه و قالب وردپرس ",
                                4,
                                24227,
                                321
                            ),
                            TopTicher(
                                1,
                                "استاد طاها اهوازی",
                                "https://raw.githubusercontent.com/ihoseinam/video-shop/main/taha.jpg",
                                "برنامه نویس فول استک موبایل",
                                3,
                                2923,
                                71
                            ),
                        )
                        itemsIndexed(topTicher) { _, item ->
                            TopTicher(data = item)
                        }
                        item { AmazingEndTich(navController) }

                    }
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    TopProduct(text = "آموزش رایگان", R.drawable.free_ic)
                    LazyRow(
                        reverseLayout = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(3.dp)
                            .wrapContentHeight()
                    ) {
                        val freePack = arrayOf(
                            DataProduct(
                                31,
                                "آموزش ووکامرس رایگان | ایجاد سایت فروشگاهی با وردپرس",
                                "علیرضا احمدی",
                                "https://www.daneshjooyar.com/wp-content/uploads/2024/02/woocommerce-min-400x225.png",
                                0,
                                100,
                            ),
                            DataProduct(
                                32,
                                "آموزش وردپرس رایگان(پروژه ساخت سایت خبری)",
                                "علیرضا احمدی",
                                "https://www.daneshjooyar.com/wp-content/uploads/2023/12/Wordpress-min-511x312.png",
                                3000000,
                                100,
                            ),
                            DataProduct(
                                33,
                                "آموزش گرامر زبان انگلیسی ( یادگیری از صفر )",
                                "تینا ظهوری",
                                "https://www.daneshjooyar.com/wp-content/uploads/2023/12/Grammar-min-400x225.png",
                                2800000,
                                100,
                            )

                        )
                        itemsIndexed(freePack) { _, item ->
                            ItemProduct(
                                data = item, navController, viewModel
                            )
                        }
                    }
                }


            }

        }

    }
}


@Composable
fun AmazingStart() {
    Column(
        modifier = Modifier
            .width(180.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = painterResource(id = R.drawable.topitem), contentDescription = "",
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier
                .width(150.dp)
                .height(120.dp),
            text = "پکیج های طلایی",
            fontSize = 34.sp,
            color = Color.White,
            fontFamily = myFont,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AmazingTicher() {
    Column(
        modifier = Modifier
            .width(190.dp)
            .clickable { }
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            modifier = Modifier
                .width(200.dp)
                .height(150.dp),
            painter = painterResource(id = R.drawable.besttich), contentDescription = "",
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            modifier = Modifier
                .width(200.dp)
                .height(120.dp),
            text = "مدرسین برتر",
            fontSize = 33.sp,
            color = Color.White,
            fontFamily = myFont,
            textAlign = TextAlign.Center
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
            .height(265.dp)
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
                    selectedTabGold.value = 1
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
fun AmazingEndTich(navController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .width(180.dp)
            .height(366.dp)
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
                    selectedTabGold.value = 0
                    navController.navigate(Screen.PackGold.route) {
                        popUpTo(Screen.Home.route) {
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun AmazingItem(navController: NavHostController, data: DataProduct) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${data.id}")
        },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(220.dp)
            .height(273.dp)
            .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            GlideImage(
                model = data.img,
                contentDescription = "",
                modifier = Modifier
                    .width(220.dp)
                    .height(140.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = data.title,
                fontFamily = myFont,
                fontSize = 13.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(end = 5.dp, start = 1.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = data.nameTicher,
                fontFamily = myFont,
                fontSize = 14.sp,
                color = dancolor,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(end = 5.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color(0x0F5A5959))
            )
            Row(
                modifier = Modifier.padding(start = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.toman),
                    contentDescription = "",
                    Modifier.size(23.dp)
                )
                Text(
                    text = darsadfun(data.priceOr, data.darsad),
                    fontFamily = myFont,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .fillMaxWidth()
                )
            }

        }
    }
}

@Composable
fun MyTopBarHome(scope: CoroutineScope, state: DrawerState) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                scope.launch {
                    state.open()
                }
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "")
            }
            Image(painter = painterResource(id = R.drawable.logotype), contentDescription = "")

        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.5.dp)
                .background(Color(0x0F4C4A4A))
        )

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MySlider(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.digiclub1,
        R.drawable.s,
        R.drawable.digiclub2,
    )
    val pagerState = com.google.accompanist.pager.rememberPagerState(
        pageCount =
        images.size
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
    Column(
        modifier
            .fillMaxWidth()
            .height(250.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier.fillMaxSize()) {
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
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 15.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                PageIndicator(
                    pageCount = images.size,
                    currentPage = pagerState.currentPage,
                    modifier = Modifier
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
    val size = animateDpAsState(targetValue = if (isSelected) 10.dp else 8.dp, label = "")
    Box(
        modifier = modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFFFFFFFF) else Color(0xFF2196F3))
    )
}

@Composable
fun TopProduct(text: String, img: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(0.5f),
        ) {
            TextButton(onClick = {
            }) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = "مشاهده همه",
                    fontSize = 14.sp,
                    fontFamily = myFont,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            Modifier.weight(0.5f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
//                modifier = Modifier
//                    .padding(end = 5.dp),
                text = text,
                fontSize = 21.sp,
                textAlign = TextAlign.End,
                fontFamily = myFont,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                painterResource(id = img),
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(50.dp)
            )

        }


    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ItemProduct(data: DataProduct, navController: NavHostController, viewModel: ShopViewModel) {
    val priceortakh = darsadfun(data.priceOr, data.darsad)
    var check by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(true) {
        viewModel.chekedProduct(data.id).collect {
            withContext(Dispatchers.Main) {
                check = it
            }
        }
    }

    Card(
        onClick = {
            navController.navigate(
                route = Screen.InfoItemScreen.route + "?data=${data.id}"
            )
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(15.dp),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(300.dp)
            .height(330.dp)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                GlideImage(
                    model = data.img,
                    contentDescription = "",
                    modifier = Modifier
                        .width(270.dp)
                        .height(160.dp),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp, start = 1.5.dp), contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "${data.darsad} %",
                        modifier = Modifier
                            .width(40.dp)
                            .background(
                                Color(0xfff32e2e),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = myFont,
                        fontSize = 13.sp
                    )
                }
            }
            Column(modifier = Modifier.weight(0.5f), verticalArrangement = Arrangement.Center) {
                Text(
                    text = data.title,
                    textAlign = TextAlign.End,
                    fontSize = 15.sp,
                    fontFamily = myFont,
                    modifier = Modifier.fillMaxWidth(),

                    )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        modifier = Modifier.padding(top = 4.dp),
                        onClick = {
                            val ee = (data.priceOr * data.darsad) / 100
                            val b = data.priceOr - ee
                            val eee = ShopTable(data.id, data.title, b, data.img, data.nameTicher)
                            viewModel.addNewProduct(eee)
                        }) {
                        AnimatedVisibility(!check) {
                            Icon(
                                Icons.Rounded.AddCircle,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(
                                        0.2.dp, Color.Red,
                                        CircleShape
                                    )
                                    .background(Color.Red)
                            )
                        }
                        AnimatedVisibility(check) {
                            Icon(
                                Icons.Default.CheckCircle,
                                contentDescription = "",
                                tint = Color(0xFF00FF0A)
                            )
                        }
                    }
                    Text(
                        text = data.nameTicher,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 4.dp),
                        fontSize = 15.sp,
                        fontFamily = myFont,
                        textAlign = TextAlign.End,
                        color = dancolor
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.5.dp)
                        .background(Color(0x0F6B6969))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            Modifier.size(24.dp),
                        )

                        Text(
                            text = priceortakh,
                            modifier = Modifier
                                .padding(start = 6.dp),
                            fontSize = 15.sp,
                            fontFamily = myFont,
                            color = Color.Black
                        )
                    }
                    val zori = String.format("%,d", data.priceOr)
                    Text(
                        text = zori,
                        modifier = Modifier
                            .padding(end = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 13.sp,
                        fontFamily = myFont,
                        textDecoration = TextDecoration.LineThrough
                    )
                }

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

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TopTicher(data: TopTicher) {
    Card(
        onClick = {
            openInfoTich.value = true
            val bb =
                TopTicher(0, data.name, data.img, data.info, data.numd, data.daneshjo, data.houre)
            infoTichstate.value = bb
        },
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .width(250.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 13.dp),
            horizontalAlignment = Alignment.End,
        ) {
            GlideImage(
                modifier = Modifier
                    .width(250.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .height(300.dp)
                    .padding(start = 6.dp, end = 6.dp, top = 4.dp),
                model = data.img,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Text(
                text = data.name,
                fontSize = 17.sp,
                fontFamily = myFont,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 6.dp)
            )
            Text(
                text = data.info,
                fontSize = 13.sp,
                fontFamily = myFont,
                color = dancolor,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(end = 6.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryHome() {
    val cat = arrayOf(
        Category(1, R.drawable.sitecat, "طراحی سایت", 142),
        Category(2, R.drawable.andcat, "برنامه نویسی موبایل", 44),
        Category(3, R.drawable.danwshga, "دروس دانشگاهی", 24),
        Category(4, R.drawable.hosh, "هوش مصنوعی", 31),
        Category(5, R.drawable.windo, "برنامه نویسی ویندوز", 88),
        Category(6, R.drawable.pagadade, "پایگاه داده", 12),
        Category(7, R.drawable.shabakan, "شبکه", 17),
        Category(8, R.drawable.bazisazi, "بازی سازی", 22),
        Category(9, R.drawable.tarahi, "طراحی و گرافیک", 70),
        Category(10, R.drawable.electrinic, "آموزش الکترونیک", 42),
        Category(11, R.drawable.casbokar, "کسب و کار", 53),
        Category(12, R.drawable.oder, "نرم افزارهای کاربردی", 32),
    )

    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "موضوعات کاربردی و منتخب", fontFamily = myFont,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(8.dp))
    FlowRow(
        maxItemsInEachRow = 3,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 3.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.Center
    ) {
        for (item in cat) {
            Catitem(data = item)
        }
        Spacer(modifier = Modifier.height(14.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Catitem(data: Category) {
    Card(
        onClick = {},
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth(0.322f)
            .padding(top = 14.dp)
            .height(193.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF8CBBEB),
                            Color.White,
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(data.img), contentDescription = "")
            Text(
                text = data.title,
                fontFamily = myFont,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = dancolor,
                    modifier = Modifier.padding(top = 3.dp)
                )
                Text(
                    text = "دوره",
                    fontFamily = myFont,
                    fontSize = 14.sp,
                    color = dancolor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = data.number.toString(),
                    fontFamily = myFont,
                    fontSize = 15.sp,
                    color = dancolor
                )

            }

        }
    }
}

val opendrawer = mutableStateOf(false)


val openInfoTich = mutableStateOf(false)

@OptIn(
    ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
@Composable
fun infoTicher(name: String, img: String, info: String, numd: Int, daneshjo: Int, houre: Int) {
    var ee by remember {
        openInfoTich
    }
    if (ee) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = { openInfoTich.value = false }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                GlideImage(
                    model = img, contentDescription = "",
                    Modifier.clip(RoundedCornerShape(24.dp))
                )
                Text(
                    text = name,
                    fontFamily = myFont,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = dancolor
                )
                Text(
                    text = info,
                    fontFamily = myFont,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(6.dp))

                FlowRow(
                    maxItemsInEachRow = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(horizontal = 1.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalArrangement = Arrangement.Center
                ) {
                    //عداد دوره
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        elevation = CardDefaults.cardElevation(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 7.dp, vertical = 9.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    text = "عدد",
                                    fontFamily = myFont,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = numd.toString(),
                                    fontFamily = myFont,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                            }
                            Text(
                                text = "تعداد دوره های فعال",
                                fontFamily = myFont,
                                fontSize = 11.sp,
                                color = Color.Black
                            )
                        }
                    }

                    //تعداد دانشجو
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        modifier = Modifier
                            .padding(1.dp),
                        elevation = CardDefaults.cardElevation(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 7.dp, vertical = 9.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    text = "نفر",
                                    fontFamily = myFont,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = String.format("%,d", daneshjo),
                                    fontFamily = myFont,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                            }

                            Text(
                                text = "تعداد دانشجو مهندس",
                                fontFamily = myFont,
                                fontSize = 11.sp,
                                color = Color.Black
                            )
                        }
                    }

                    //ساعت
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        modifier = Modifier
                            .padding(1.dp),
                        elevation = CardDefaults.cardElevation(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 7.dp, vertical = 9.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    text = "ساعت",
                                    fontFamily = myFont,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = houre.toString(),
                                    fontFamily = myFont,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = dancolor
                                )
                            }
                            Text(
                                text = "مدت زمان آموزش",
                                fontFamily = myFont,
                                fontSize = 11.sp,
                                color = Color.Black
                            )
                        }
                    }


                }
                Spacer(modifier = Modifier.height(55.dp))

            }
        }
    }

}

var opente = mutableStateOf(false)

@Composable
private fun openTelegram(context: Context) {
    var y by remember {
        opente
    }
    val uriHandler = LocalUriHandler.current
    try {
        if (y) {
            uriHandler.openUri("tg://resolve?domain=i_hoseinam")
        }
    } catch (e: Exception) {
        Toast.makeText(context, "Not Found Telegram", Toast.LENGTH_SHORT).show()
    }


}