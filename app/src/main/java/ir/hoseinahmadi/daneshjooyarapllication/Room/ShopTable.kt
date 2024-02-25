package ir.hoseinahmadi.daneshjooyarapllication.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopTable(
    @PrimaryKey
    val id :Int,
    val name :String,
    val price:Int,
    val img :String,
    val nameTich:String,
)
