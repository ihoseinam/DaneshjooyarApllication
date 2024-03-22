package ir.hoseinahmadi.daneshjooyarapllication.Screen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.gson.internal.JavaVersion
import ir.hoseinahmadi.daneshjooyarapllication.Navigation.Screen
import ir.hoseinahmadi.daneshjooyarapllication.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

var swichSend = mutableStateOf(false)

@Composable
fun LoginScreen(navHostController: NavHostController) {
    val switch by remember {
        swichSend
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(!switch) {
            SenCode()
        }
        AnimatedVisibility(switch) {
            Verify(navHostController)
        }
    }
}

val email = mutableStateOf("")

@Composable
fun SenCode() {
    var emailText by remember {
        email
    }
    var start by remember {
        mutableStateOf(false)
    }
    Column {
        LaunchedEffect(start) {
            if (start) {
                Log.e("pasi", "start ")
                launch(Dispatchers.IO) {
                    Log.e("pasi", "reques")
                    val responce = try {
                        ApiClient.api.senCode(emailText)
                    } catch (e: Exception) {
                        Log.e("pasi", " eroorr : ${e.message}")
                        start = false
                        return@launch
                    }
                    if (responce.isSuccessful) {
                        Log.e("pasi", responce.body()!!.message)
                        swichSend.value = true
                        start = false
                    } else {
                        start = false
                    }
                }
            }
        }
        OutlinedTextField(value = emailText, onValueChange = { emailText = it })
        Button(onClick = {
            start = true
            Log.e("pasi", "click to login")
        }) {
            Text(text = "ورود")
        }
    }

}

@SuppressLint("CommitPrefEdits")
@Composable
fun Verify(navHostController: NavHostController) {
    var code by remember {
        mutableStateOf("")
    }
    var startVerify by remember {
        mutableStateOf(false)
    }
    val contex = LocalContext.current
    LaunchedEffect(startVerify) {
        if (startVerify) {
            launch(Dispatchers.IO) {
                val responce = try {
                    ApiClient.api.verify(
                        anid = UUID.randomUUID().toString(),
                        email = email.value,
                        code = code
                    )
                } catch (e: Exception) {
                    startVerify = false
                    return@launch
                }
                if (responce.isSuccessful) {
                    Log.e("pasi", responce.body()!!.message)
                    Log.e("pasi", "login is true")
                    withContext(Dispatchers.Main){
                       val pref = contex.getSharedPreferences("checklogin", Context.MODE_PRIVATE)
                        val edit =pref.edit()
                        edit.putBoolean("login",true)
                        edit.apply()
                        navHostController.navigate(Screen.MyProfile.route){
                            popUpTo(Screen.LoginScreen.route){
                                inclusive =true
                            }
                        }
                    }
                }
            }
        }
    }
    Column {
        TextField(value = code, onValueChange = {
            code = it
        })
        Button(onClick = { startVerify = true }) {
            Text(text = "login")
        }
    }


}

