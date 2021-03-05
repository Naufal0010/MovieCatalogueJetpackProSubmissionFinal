package com.exercise.moviecatalogue.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.databinding.ActivityMainBinding
import com.exercise.moviecatalogue.fragment.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = applicationContext.resources.getString(R.string.app_name)
        supportActionBar?.elevation = 0f

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        with(binding) {
            viewPager.adapter = sectionsPagerAdapter
            tabs.setupWithViewPager(viewPager)
        }

    }
}