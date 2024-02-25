package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopDao
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopTable
import kotlinx.coroutines.flow.Flow

class FaveRepository(private val Favedao: FaveDao) {

    val allProduct: Flow<List<FavoriteTable>> = Favedao.getAllFaveItem()

    val allCount = Favedao.getFaveCount()
    suspend fun addNewFaveItem(product: FavoriteTable) {
        Favedao.addFaveItem(product)
    }


    suspend fun deleteFave(product: FavoriteTable) {
        Favedao.DeleteFaveItem(product)
    }

     fun isFaveItemExist(id: Int): Flow<Boolean> = Favedao.isFaveItemExist(id)



}