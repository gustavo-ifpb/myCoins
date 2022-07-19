package br.edu.ifpb.mycoins.ui.coinlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifpb.mycoins.data.Coin
import br.edu.ifpb.mycoins.databinding.ActivityCoinsListBinding

class CoinsListActivity : AppCompatActivity() {

    private val viewModel: CoinListViewModel by viewModels()
    private lateinit var binding: ActivityCoinsListBinding
    private lateinit var adapter: CoinsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoinsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareSwipeRefresh()
        prepareRecyclerView()
        setupCoinsObserver()
    }

    private fun prepareSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener { viewModel.getCoins() }
    }

    private fun prepareRecyclerView() {
        adapter = CoinsAdapter(
            object : CoinsAdapter.ItemClickListener {

                override fun onClick(coin: Coin) {
                    TODO("Not yet implemented")
                }
            }
        )
        binding.coinsList.adapter = adapter
        binding.swipeRefresh.isRefreshing = true
        viewModel.getCoins()
    }

    private fun setupCoinsObserver() {
        viewModel.coins.observe(this) { coins ->
            adapter.setData(coins)
            binding.swipeRefresh.isRefreshing = false
        }
    }
}
