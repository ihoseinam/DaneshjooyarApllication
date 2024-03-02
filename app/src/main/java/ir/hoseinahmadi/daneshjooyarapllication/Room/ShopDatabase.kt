package ir.hoseinahmadi.daneshjooyarapllication.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FaveDao
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable

@Database(entities = [ShopTable::class, FavoriteTable:: class], version = 2, exportSchema = false)
abstract class ShopDatabase :RoomDatabase(){
    abstract fun ShopDao(): ShopDao
    abstract fun FaveDao():FaveDao

    companion object {
        @Volatile
        private var INSTANCE: ShopDatabase? = null

        fun getDatabase(context: Context):ShopDatabase{
            val instance=INSTANCE
            if (instance!=null){
                return instance
            }
            synchronized(this){
                val instance =Room.databaseBuilder(
                    context.applicationContext,
                    ShopDatabase::class.java,
                    "ShopDatabase"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }

}