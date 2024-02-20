package ir.hoseinahmadi.daneshjooyarapllication.dataClas

import androidx.compose.runtime.Immutable

@Immutable
data class DataProduct(
    val id:Int,
    val title :String,
    val nameTicher :String,
    val img :Int,
    val priceOr:Int,
    val darsad :Int =0,
    val Houre :Int,
    val student :Int,
    val jalase :Int,
    val info :List<String>,
    val more:String="",
    val videoUrl:String="",
)
