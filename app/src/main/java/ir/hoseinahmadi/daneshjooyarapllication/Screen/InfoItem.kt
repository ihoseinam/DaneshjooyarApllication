package ir.hoseinahmadi.daneshjooyarapllication.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.gson.Gson
import ir.hoseinahmadi.daneshjooyarapllication.dataClas.DataProduct

@Composable
fun InfoItem(navController: NavHostController, data: String){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val gson =Gson()
        val dataitem =gson.fromJson(data,DataProduct::class.java)

        Text(text = "${dataitem.id}${dataitem.priceOr}${dataitem.title}${dataitem.nameTicher} ", fontSize = 30.sp, color = Color.Black)
    }
}