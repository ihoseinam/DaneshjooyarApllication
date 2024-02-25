package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.hoseinahmadi.daneshjooyarapllication.Room.Fave.FavoriteTable
import kotlinx.coroutines.flow.Flow

@Dao
interface FaveDao {

    @Query("SELECT * FROM FavoriteTable")
    fun getAllFaveItem(): Flow<List<FavoriteTable>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFaveItem(item: FavoriteTable)

    @Delete
    suspend fun DeleteFaveItem(item: FavoriteTable)


    @Query("SELECT EXISTS(SELECT * FROM FavoriteTable WHERE id =:itemId)")
    fun isFaveItemExist(itemId: Int): Flow<Boolean>

    @Query("SELECT COUNT(*) FROM FavoriteTable")
    fun getFaveCount(): Flow<Int>
}