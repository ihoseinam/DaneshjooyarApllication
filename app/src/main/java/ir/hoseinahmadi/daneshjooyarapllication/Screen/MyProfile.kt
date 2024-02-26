package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveViewModel
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopViewModel
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

val selectedTabProfile = mutableIntStateOf(3)

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(navController: NavHostController) {
    var selectedTabIndex by remember {
        selectedTabProfile
    }
    val viewm = viewModel(FaveViewModel::class.java)
    val num = viewm.getProductCount.collectAsState(0)
    val tabTitle = listOf(
        "لایسنس ها",
        "دوره ها",
        "علاقه مندی",
        "پروفایل",
    )
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            val ee = LocalContext.current
            val pref = ee.getSharedPreferences("username", Context.MODE_PRIVATE)

            val eeee = mutableStateOf(pref.getString("name", "کاربر ناشناس").toString())
            var nameState by remember {
                eeee
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                }) {
                    Icon(
                        Icons.Rounded.Edit, contentDescription = "", tint = dancolor,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = nameState,
                        fontFamily = myFont,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(id = R.drawable.avatar), contentDescription = "",
                        Modifier
                            .size(95.dp)
                            .padding(5.dp)
                            .clip(CircleShape)
                    )
                }


            }

            TabRow(
                contentColor = Color.Black,
                containerColor = Color(0xFFFFFFFF),
                indicator = { line ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(line[selectedTabIndex])
                            .height(3.dp)
                            .background(Color.Red)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 1.5.dp),
                selectedTabIndex = selectedTabIndex
            ) {
                tabTitle.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.DarkGray,
                        text = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (index == 2 && num.value > 0) {
                                    Badge(
                                        contentColor = Color.White,
                                        containerColor = Color.Red
                                    ) {
                                        Text(
                                            num.value.toString(),
                                            color = Color.White,
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(1.5.dp))
                                    Text(
                                        text = title,
                                        fontFamily = myFont,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                } else {
                                    Text(
                                        text = title,
                                        fontFamily = myFont,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }


                            }
                        },
                    )

                }
            }
        }
        when (selectedTabIndex) {
            0 -> Licence()
            1 -> Pack()
            2 -> Love(viewm, num.value)
            3 -> Profile()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Profile() {
    emty("شما هنوز وارد حساب کاربری نشده اید")
}
@Composable
fun Pack() {
    emty("هیچ دوره فعالی ندارید")
}

@Composable
fun Licence() {
    emty("هیچ لایسنس فعالی ندارید")
}

@Composable
fun Love(viewModel: FaveViewModel, num: Int) {
    var bb by remember {
        mutableStateOf(emptyList<FavoriteTable>())
    }
    LaunchedEffect(true) {
        viewModel.allProduct.collectLatest {
            withContext(Dispatchers.Main) {
                bb = it
            }
        }
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (num <= 0) {
            item {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(70.dp))
                    Image(
                        painter = painterResource(id = R.drawable.empty_cart),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .height(200.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "لیست علاقه مندی ها خالی می باشد",
                        fontFamily = myFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }

            }
        } else {
            itemsIndexed(bb) { index, item ->
                FaveItem(data = item, viewModel = viewModel)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun FaveItem(data: FavoriteTable, viewModel: FaveViewModel) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Red,
                    ),
                    onClick = {
                        val ee = FavoriteTable(data.id, "", 0, "", "")
                        viewModel.deleteProduct(ee)
                    }) {
                    Icon(
                        painterResource(id = R.drawable.ic_delete),
                        contentDescription = "",
                        tint = Color.Red,
                    )

                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f),
                horizontalAlignment = Alignment.End,
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.End,
                    text = data.name,
                    fontFamily = myFont
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.nameTich, fontFamily = myFont,
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
                        text = String.format("%,d", data.price),
                        fontFamily = myFont,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Red
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(0.4f)
            ) {
                GlideImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .padding(4.dp),
                    contentScale = ContentScale.Fit,
                    model = data.img,
                    contentDescription = ""
                )
            }


        }
    }

}
@Composable
fun emty(text:String){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.emty), contentDescription = "")
        Text(text = text,
            fontFamily = myFont,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold)

    }
}