package ir.hoseinahmadi.daneshjooyarapllication.dataClas

import androidx.compose.runtime.Immutable

@Immutable
data class DataProduct(
    val id:Int,
    val title :String,
    val nameTicher :String,
    val img :String,
    val priceOr:Int,
    val darsad :Int =0,
    val Houre :Int=0,
    val student :Int=0,
    val jalase :Int=0,
    val info :List<String> = emptyList(),
    val more:String="",
    val videoUrl:String="",
)
