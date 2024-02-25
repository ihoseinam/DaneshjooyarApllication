package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopDatabase
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopTable
import ir.hoseinahmadi.daneshjooyarapllication.Room.repository.ShopRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FaveViewModel(application: Application) : AndroidViewModel(application) {
    val allProduct: Flow<List<FavoriteTable>>
    private val repositore: FaveRepository

    init {
        val FaveDao = ShopDatabase.getDatabase(application).FaveDao()
        repositore = FaveRepository(FaveDao)
        allProduct = repositore.allProduct
    }

    fun addNewProduct(product: FavoriteTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repositore.addNewFaveItem(product)
        }
    }


    fun deleteProduct(product: FavoriteTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repositore.deleteFave(product)
        }
    }


    fun checkProduct(id: Int): Flow<Boolean> {
        return repositore.isFaveItemExist(id)
    }


    val getProductCount: Flow<Int> = repositore.allCount

}