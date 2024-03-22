package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.daneshjooyarapllication.R
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.dancolor
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

var errorname = mutableStateOf(false)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun AcountScreen(navController: NavHostController) {
    val ee = LocalContext.current
    val pref = ee.getSharedPreferences("username", Context.MODE_PRIVATE)

    var nameOrFa by remember {
        mutableStateOf(pref.getString("name", ""))
    }
    var phon by remember {
        mutableStateOf(pref.getString("phone", ""))
    }
    var er by remember {
        errorname
    }
    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {},
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.Close, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                painter = painterResource(id = R.drawable.logotype),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = nameOrFa.toString(), onValueChange = { nameOrFa = it },
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(60.dp),
                textStyle = TextStyle(
                    textDirection = TextDirection.Rtl,
                    fontFamily = myFont,
                    fontSize = 14.sp
                ),
                isError = er,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                supportingText = {
                    if (er) {
                        Text(
                            text = "چیزی وارد کنید",
                            Modifier.fillMaxWidth(),
                            style = TextStyle(
                                textDirection = TextDirection.Ltr
                            ),
                            textAlign = TextAlign.End,
                            fontFamily = myFont,
                        )
                    }
                },
                label = {
                    Text(
                        text = "نام ",
                        Modifier.fillMaxWidth(),
                        style = TextStyle(
                            textDirection = TextDirection.Ltr
                        ),
                        textAlign = TextAlign.End,
                        fontFamily = myFont,
                    )
                },
                placeholder = {
                    Text(
                        text = " نام خود را وارد کنید",
                        Modifier.fillMaxWidth(),
                        style = TextStyle(
                            textDirection = TextDirection.Ltr
                        ),
                        textAlign = TextAlign.End,
                        fontFamily = myFont,
                    )
                },
            )
            Spacer(modifier = Modifier.height(5.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(60.dp),
                textStyle = TextStyle(
                    textDirection = TextDirection.Rtl,
                    fontFamily = myFont,
                    fontSize = 14.sp
                ),
                value = phon.toString(),
                onValueChange = {
                    phon = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                singleLine = true,
                label = {
                    Text(
                        text = "تلفن",
                        fontFamily = myFont,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            textDirection = TextDirection.Ltr
                        ),
                        textAlign = TextAlign.End,
                    )
                },
                placeholder = {
                    Text(
                        text = "شماره تلفن خود را وارد کنید",
                        fontFamily = myFont,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        style = TextStyle(
                            textDirection = TextDirection.Ltr
                        ),
                        textAlign = TextAlign.End,
                    )
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = dancolor,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp)
                        .clip(RoundedCornerShape(11.dp)),
                    onClick = {
                        er = nameOrFa!!.isEmpty()
                        if (nameOrFa!!.isNotEmpty()) {
                            val edit = pref.edit()
                            edit.putString("name", nameOrFa)
                            edit.putString("phone", phon)
                            edit.apply()
                            navController.popBackStack()
                        }
                    }) {
                    Text(
                        text = "ذخیره",
                        fontFamily = myFont,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }

            }


        }

    }
}