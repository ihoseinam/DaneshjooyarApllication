package ir.hoseinahmadi.daneshjooyarapllication.Room.Fave

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
class FaveViewModel
@Inject constructor(

    private val repositore: FaveRepository
) : ViewModel() {

    val allProduct: Flow<List<FavoriteTable>> = repositore.allProduct

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