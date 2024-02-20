package ir.hoseinahmadi.daneshjooyarapllication.dataClas

import androidx.compose.runtime.Immutable

@Immutable
data class Category(
    val id :Int,
    val img:Int,
    val title:String,
    val number:Int,
)
