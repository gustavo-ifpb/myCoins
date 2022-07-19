package br.edu.ifpb.mycoins.ui.coinlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifpb.mycoins.api.API
import br.edu.ifpb.mycoins.data.Coin
import kotlinx.coroutines.launch

class CoinListViewModel : ViewModel() {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    fun getCoins() {
        viewModelScope.launch {
            _coins.value = API.getCoins().data
        }
    }
}
