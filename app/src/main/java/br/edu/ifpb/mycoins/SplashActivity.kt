package br.edu.ifpb.mycoins

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifpb.mycoins.databinding.ActivitySplashBinding
import br.edu.ifpb.mycoins.ui.coinlist.CoinsListActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        navigateToCoinList()
    }

    private fun navigateToCoinList() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(baseContext, CoinsListActivity::class.java))
            finish()
        }, DELAY)
    }

    companion object {
        const val DELAY = 1000L
    }
}
