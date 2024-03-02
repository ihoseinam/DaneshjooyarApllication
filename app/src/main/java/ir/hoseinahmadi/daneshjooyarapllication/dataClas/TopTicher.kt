package ir.hoseinahmadi.daneshjooyarapllication.dataClas

import androidx.compose.runtime.Immutable

@Immutable
data class TopTicher(
    val id :Int,
    val name:String,
    val img:String,
    val info :String,
    val numd :Int=0,
    val daneshjo :Int=0,
    val houre :Int=0,
)

