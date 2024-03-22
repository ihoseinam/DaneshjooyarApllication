package ir.hoseinahmadi.daneshjooyarapllication.Room.shop

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {
    @Query("SELECT * FROM ShopTable")
    fun getAllProduct(): Flow<List<ShopTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewProduct(product: ShopTable)

    @Update
    suspend fun updateProduct(product: ShopTable)

    @Delete
    suspend fun deleteProduct(product: ShopTable)

    @Query("DELETE  FROM shoptable")
    suspend fun deleteAllProduct()

    @Query("SELECT COUNT(*) FROM ShopTable")
    fun getProductCount(): Flow<Int>

    @Query("SELECT EXISTS(SELECT * FROM shoptable WHERE id =:itemId)")
    fun isShopItemExist(itemId: Int): Flow<Boolean>

    @get:Query("SELECT price FROM shoptable")
    val allPrice: Flow<List<Int>>
}
