package ir.hoseinahmadi.daneshjooyarapllication.Room.shop

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class ShopRepository @Inject constructor (
    private val shopDao: ShopDao) {

    val allProduct: Flow<List<ShopTable>> = shopDao.getAllProduct()
    val allCount = shopDao.getProductCount()

    val allPrice :Flow<List<Int>> =shopDao.allPrice
    suspend fun addNewProduct(product: ShopTable) {
        shopDao.addNewProduct(product)
    }

    suspend fun updateProduct(product: ShopTable) {
        shopDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: ShopTable) {
        shopDao.deleteProduct(product)
    }

    suspend fun deleteAllProduct() {
        shopDao.deleteAllProduct()
    }

  fun checkProduct(id:Int): Flow<Boolean> = shopDao.isShopItemExist(id)



}