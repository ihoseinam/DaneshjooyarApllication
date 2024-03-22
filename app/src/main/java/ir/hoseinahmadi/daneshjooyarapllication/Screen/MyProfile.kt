package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveViewModel
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

val selectedTabProfile = mutableIntStateOf(3)

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfileScreen(
    navController: NavHostController,
    viewModel: FaveViewModel = hiltViewModel()
) {
    var selectedTabIndex by remember {
        selectedTabProfile
    }
    val num = viewModel.getProductCount.collectAsState(0)
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
                                    Spacer(modifier = Modifier.width(2.2.dp))
                                    Text(
                                        text = title,
                                        fontFamily = myFont,
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                } else {
                                    Text(
                                        text = title,
                                        fontFamily = myFont,
                                        fontSize = 12.sp,
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
            2 -> Love(viewModel, num.value)
            3 -> Profile(navController)
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Profile(navController: NavHostController) {
    val ee = LocalContext.current
    val pref = ee.getSharedPreferences("username", Context.MODE_PRIVATE)
    val name = mutableStateOf(pref.getString("name", "کاربر ناشناس"))
    val phone = mutableStateOf(pref.getString("phone", ""))
    val nameState by remember {
        name
    }
    val phoneState by remember {
        phone
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = {
            navController.navigate(Screen.Acount.route)
        }) {
            Icon(
                Icons.Rounded.Edit, contentDescription = "", tint = dancolor,
                modifier = Modifier.size(30.dp)
            )
        }
        Column(
            modifier = Modifier.padding(end = 4.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = nameState.toString(),
                fontFamily = myFont,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 18.sp
            )
            Text(
                text = phoneState.toString(),
                fontFamily = myFont,
                color = Color(0xC0000000),
                fontSize = 11.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .alpha(0.4f),
        color = Color.LightGray,
    )
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(13.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            menuProfile("پشتیبانی", R.drawable.posh)
            menuProfile("کیف پول", R.drawable.digi_wallet)
            menuProfile("احراز هویت", R.drawable.digi_user)
        }
        Spacer(modifier = Modifier.height(13.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .alpha(0.4f),
            color = Color.LightGray,
        )
        Spacer(modifier = Modifier.height(8.dp))
        profileInfo()

        Button(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
            Text(text = "Login")
        }

    }


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
                        fontSize = 25.sp,
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
            .padding(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(0.1f)
                    .padding(top = 32.dp)
            ) {
                IconButton(
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.Red,
                    ),
                    onClick = {
                        val ee = FavoriteTable(data.id, "", 0, "", "")
                        viewModel.deleteProduct(ee)
                    },
                    modifier = Modifier.size(30.dp)
                ) {
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
                    .weight(0.55f),
                horizontalAlignment = Alignment.End,
            ) {
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
                    .weight(0.35f)
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
fun emty(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.emty), contentDescription = "")
        Text(
            text = text,
            fontFamily = myFont,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun profileInfo() {
    profileInfoItem("آخرین دوره هایی که شرکت کرده اید", Icons.Rounded.AccountCircle)
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .alpha(0.4f),
        color = Color.LightGray
    )
    profileInfoItem("سفارشات اخیر شما", Icons.Rounded.DateRange)
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .alpha(0.4f),
        color = Color.LightGray
    )
    profileInfoItem("تیکت ها", Icons.Rounded.Call)
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .alpha(0.4f),
        color = Color.LightGray
    )
    profileInfoItem("سفارشات و تراکنش ها", Icons.Rounded.ShoppingCart)

}

@Composable
fun profileInfoItem(text: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "", tint = Color.Black)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = text,
                        fontFamily = myFont,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Icon(icon, contentDescription = "")
                }

            }

        }

    }
}

@Composable
fun menuProfile(text: String, icon: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            Modifier
                .size(60.dp)
                .padding(bottom = 4.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            fontFamily = myFont,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )


    }
}