package com.exercise.moviecatalogue.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exercise.moviecatalogue.databinding.ActivitySplashScreenBinding
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val background = object : Thread() {
            override fun run() {
                super.run()

                try {
                    sleep(3000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        background.start()
    }
}