package com.example.wartajemaatapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wartajemaatapp.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Menggunakan tread main
        activityScope.launch {
            //Jeda 3 detik
            delay(3000)

            //Pindah activity dan destroy
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finishAffinity()
        }
    }

    override fun onPause() {
        // Membatalkan Coroutine
        activityScope.cancel()
        super.onPause()
    }


}