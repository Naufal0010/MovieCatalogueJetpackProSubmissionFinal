package com.exercise.moviecatalogue.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.databinding.ActivityFavoriteBinding
import com.exercise.moviecatalogue.fragment.favorite.SectionsFavoriteAdapter

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title =
            applicationContext.resources.getString(R.string.favorite_catalogue)
        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionsFavoriteAdapter = SectionsFavoriteAdapter(this, supportFragmentManager)
        with(binding) {
            viewPager.adapter = sectionsFavoriteAdapter
            tabs.setupWithViewPager(viewPager)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}