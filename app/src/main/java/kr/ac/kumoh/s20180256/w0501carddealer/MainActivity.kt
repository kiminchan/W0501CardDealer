package kr.ac.kumoh.s20180256.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20180256.w0501carddealer.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        val c = Random.nextInt(52)
        Log.i("Test", "$c : ${getCardName(c)}")

        val res = resources.getIdentifier(
            getCardName(c),
            "drawable",
            packageName
        )
        binding.card1.setImageResource(res)
        //binding.card1.setImageResource(R.drawable.c_2_of_hearts)
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}