package ir.hoseinahmadi.daneshjooyarapllication.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveDao
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopDao
import ir.hoseinahmadi.daneshjooyarapllication.Room.shop.ShopTable

@Database(entities = [ShopTable::class, FavoriteTable:: class], version = 2, exportSchema = false)
abstract class ShopDatabase :RoomDatabase(){
    abstract fun ShopDao(): ShopDao
    abstract fun FaveDao():FaveDao

}