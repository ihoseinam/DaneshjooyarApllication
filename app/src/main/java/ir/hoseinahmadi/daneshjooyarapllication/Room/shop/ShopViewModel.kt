package ir.hoseinahmadi.daneshjooyarapllication.Room.shop

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val repositore: ShopRepository
) : ViewModel() {

    val allProduct: Flow<List<ShopTable>> = repositore.allProduct

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