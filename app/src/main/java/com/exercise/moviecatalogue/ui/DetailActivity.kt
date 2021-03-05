package com.exercise.moviecatalogue.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.databinding.ActivityDetailBinding
import com.exercise.moviecatalogue.viewmodel.DetailViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val idMovie = extras.getString(EXTRA_MOVIE)
            val idTvShow = extras.getString(EXTRA_TV)

            if (idMovie != null) {
                setProgressBar(true)

                viewModel.setSelectedMovie(idMovie)
                viewModel.getMovie().observe(this, { movies ->
                    setProgressBar(false)
                    populateMovie(movies)
                })
            }

            if (idTvShow != null) {
                setProgressBar(true)

                viewModel.setSelectedTvShow(idTvShow)
                viewModel.getTvShows().observe(this, { tvShows ->
                    setProgressBar(false)
                    populateTvShow(tvShows)
                })
            }
        }
    }

    private fun populateMovie(movies: MoviesModel) {
        with(binding) {
            tvTitle.text = movies.title
            tvGenre.text = movies.genre
            tvLength.text = movies.length
            tvRelease.text = movies.release
            tvDetail.text = movies.description
            Glide.with(binding.root)
                    .load(movies.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh))
                    .error(R.drawable.ic_broken_image)
                    .into(imageViewDetail)
        }
    }

    private fun populateTvShow(tvShows: TvShowsModel) {
        with(binding) {
            tvTitle.text = tvShows.title
            tvGenre.text = tvShows.genre
            tvLength.text = tvShows.length
            tvRelease.text = tvShows.release
            tvDetail.text = tvShows.description
            Glide.with(binding.root)
                    .load(tvShows.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh))
                    .error(R.drawable.ic_broken_image)
                    .into(imageViewDetail)
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        }
        else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }
}