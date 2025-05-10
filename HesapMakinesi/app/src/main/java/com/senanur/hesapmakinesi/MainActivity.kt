package com.senanur.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.senanur.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var girilenSayi = ""
    private var toplamSonucu = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val sayiTuslari = listOf(
            binding.btn0,binding.btn1,binding.btn2,binding.btn3,binding.btn4,
            binding.btn5,binding.btn6,binding.btn7,binding.btn8,binding.btn9
        )

        sayiTuslari.forEachIndexed { index, tus ->
            tus.setOnClickListener{
                girilenSayi += index.toString()
                binding.tvDisplay.text = girilenSayi
            }
        }

        binding.btnAdd.setOnClickListener {
            toplamSonucu += girilenSayi.toIntOrNull() ?: 0
            girilenSayi = ""
            binding.tvDisplay.text ="+"
        }

        binding.btnEquals.setOnClickListener {
            toplamSonucu +=girilenSayi.toIntOrNull() ?: 0
            binding.tvDisplay.text = toplamSonucu.toString()
            girilenSayi = ""
            toplamSonucu = 0
        }
        
        binding.btnClear.setOnClickListener {
            girilenSayi = ""
            toplamSonucu = 0
            binding.tvDisplay.text="0"
        }
    }
}