package ir.hoseinahmadi.daneshjooyarapllication.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ir.hoseinahmadi.daneshjooyarapllication.Room.repository.ShopRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ShopViewModel(application: Application) : AndroidViewModel(application) {
    val allProduct: Flow<List<ShopTable>>
    private val repositore: ShopRepository

    init {
        val shopDao = ShopDatabase.getDatabase(application).ShopDao()
        repositore = ShopRepository(shopDao)
        allProduct = repositore.allProduct
    }

    fun addNewProduct(product: ShopTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repositore.addNewProduct(product)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repositore.deleteAllProduct()
        }
    }

    fun deleteProduct(product: ShopTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repositore.deleteProduct(product)
        }
    }

    val getProductCount: Flow<Int> = repositore.allCount

    val allPrice: Flow<List<Int>> = repositore.allPrice


    fun chekedProduct(id: Int): Flow<Boolean> {
        return repositore.checkProduct(id)
    }
}