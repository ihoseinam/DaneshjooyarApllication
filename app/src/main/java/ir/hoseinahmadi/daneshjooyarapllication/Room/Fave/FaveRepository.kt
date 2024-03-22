package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class FaveRepository @Inject constructor(
    private val Favedao: FaveDao) {
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