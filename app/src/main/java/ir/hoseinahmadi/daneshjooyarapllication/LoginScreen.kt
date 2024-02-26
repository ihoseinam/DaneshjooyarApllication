package ir.hoseinahmadi.daneshjooyarapllication

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.hoseinahmadi.daneshjooyarapllication.ui.theme.myFont

var errorname = mutableStateOf(false)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun LoginScreen(navController: NavHostController) {
    val ee = LocalContext.current
    val pref = ee.getSharedPreferences("username", Context.MODE_PRIVATE)

    var nameOrFa by remember {
        mutableStateOf("")
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
            Spacer(modifier = Modifier.height(60.dp))
            TextField(
                value = nameOrFa, onValueChange = { nameOrFa = it },
                modifier = Modifier.fillMaxWidth(0.9f),
                textStyle = TextStyle(textDirection = TextDirection.Rtl),
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
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            ) {
                TextButton(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth(),
                    onClick = {
                        er = nameOrFa.isEmpty()
                        if (nameOrFa.isNotEmpty()) {
                            val edit = pref.edit()
                            edit.putString("name", nameOrFa)
                            edit.apply()
                            navController.popBackStack()
                        }
                    }) {
                    Text(
                        text = "ثبت نام",
                        fontFamily = myFont,
                        fontSize = 16.sp
                    )
                }
                Button(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth(),
                    onClick = {
                        er = nameOrFa.isEmpty()
                        if (nameOrFa.isNotEmpty()) {
                            val edit = pref.edit()
                            edit.putString("name", nameOrFa)
                            edit.apply()
                            navController.popBackStack()
                        }
                    }) {
                    Text(
                        text = "ورود",
                        fontFamily = myFont,
                        fontSize = 16.sp
                    )
                }
            }
            TextButton(onClick = {}) {
                Text(
                    text = "مشخصات خودرا فراموش کرده اید؟",
                    fontFamily = myFont,
                    fontSize = 12.sp
                )
            }

        }

    }
}