package br.edu.ifpb.mycoins.ui.coinlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpb.mycoins.R
import br.edu.ifpb.mycoins.data.Coin
import br.edu.ifpb.mycoins.databinding.CoinListItemBinding

class CoinsAdapter(
    private val itemClickListener: ItemClickListener,
) : RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    private var data: List<Coin>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.coin_list_item, parent, false)

        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.let { coins ->
            holder.bind(coins.get(position))
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    fun setData(coins: List<Coin>) {
        data = coins
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        view: View,
        onClickListener: ItemClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val viewBinding = CoinListItemBinding.bind(view)
        private var coin: Coin? = null

        init {
            viewBinding.root.setOnClickListener {
                coin?.let {
                    onClickListener.onClick(it)
                }
            }
        }

        fun bind(coin: Coin) {
            this.coin = coin
            viewBinding.name.text = coin.symbol
            viewBinding.price.text = coin.price
        }
    }

    interface ItemClickListener {
        fun onClick(coin: Coin)
    }
}
