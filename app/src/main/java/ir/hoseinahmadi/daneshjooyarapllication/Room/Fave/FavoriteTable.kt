package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class FavoriteTable(
@PrimaryKey
val id :Int,
val name :String,
val price:Int,
val img :String,
val nameTich:String,
)

