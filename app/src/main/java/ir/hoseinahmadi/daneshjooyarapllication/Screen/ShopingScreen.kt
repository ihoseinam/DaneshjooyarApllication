package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopViewModel
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

val openDialog = mutableStateOf(false)

@OptIn(DelicateCoroutinesApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ShopingCard(
    navController: NavHostController,
    viewModel: ShopViewModel = hiltViewModel(),
) {
    var llll by remember {
        mutableStateOf(emptyList<ShopTable>())
    }
    var allPrice by remember {
        mutableIntStateOf(0)
    }
    LaunchedEffect(true) {
        launch(Dispatchers.IO) {
            viewModel.allProduct.collectLatest {
                withContext(Dispatchers.Main) {
                    llll = it
                }
            }
        }
        launch(Dispatchers.IO) {
            viewModel.allPrice.collect {
                val totalAge = it.sum()
                withContext(Dispatchers.Main) {
                    allPrice = totalAge
                }
            }
        }

    }
    val cartCount = viewModel.getProductCount.collectAsState(0)
    DialogShop(viewModel)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "سبد خرید شما",
                        fontSize = 19.sp,
                        fontFamily = myFont,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 6.dp),
                        color = Color.Black,
                        textAlign = TextAlign.End
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { openDialog.value = true }) {
                        Icon(Icons.Default.Delete, contentDescription = "")
                    }
                }

            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0x0FB0AFAF))
                    .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = ":مجموع سبد خرید",
                        fontFamily = myFont,
                        fontSize = 16.sp
                    )
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            Modifier.size(24.dp),
                        )

                        val zori = String.format("%,d", allPrice)
                        Text(
                            text = zori,
                            fontFamily = myFont,
                            fontSize = 15.sp
                        )
                    }
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "ادامه فرآیند خرید",
                        fontFamily = myFont,
                        fontSize = 14.sp
                    )
                }
            }

        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (cartCount.value <= 0) {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(90.dp))
                        Image(
                            painter = painterResource(id = R.drawable.empty_cart),
                            contentDescription = "",
                            modifier = Modifier.size(300.dp, 200.dp)
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            text = "سبد خرید خالی می باشد",
                            fontFamily = myFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            } else {

                items(llll) {
                    ShopItem(data = it, viewModel, navController)
                }


            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ShopItem(data: ShopTable, viewModel: ShopViewModel, navController: NavHostController) {
    Card(
        onClick = {
            navController.navigate(Screen.InfoItemScreen.route + "?data=${data.id}")
        },
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
                        val ee = ShopTable(data.id, "", 0, "", "")
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogShop(viewModel: ShopViewModel) {
    var pasi by remember {
        openDialog
    }
    if (pasi) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                Button(
                    modifier = Modifier.fillMaxWidth(0.4f),
                    onClick = {
                        viewModel.deleteAll()
                        openDialog.value = false
                    },
                ) {
                    Text(
                        text = "حذف شود",
                        fontFamily = myFont,
                    )
                }
            },
            dismissButton = {
                TextButton(
                    modifier = Modifier.fillMaxWidth(0.4f),
                    onClick = { openDialog.value = false },
                ) {
                    Text(
                        text = "بستن",
                        fontFamily = myFont,
                    )
                }
            },
            text = {
                Text(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    text = "لیست خرید پاکسازی شود؟",
                    fontFamily = myFont,
                    textAlign = TextAlign.End,
                )
            },

            )


    }
}