package com.exercise.moviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.databinding.ActivityDetailBinding
import com.exercise.moviecatalogue.model.MoviesModel
import com.exercise.moviecatalogue.model.TvShowsModel
import com.exercise.moviecatalogue.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val idMovie = extras.getString(EXTRA_MOVIE)
            val idTvShow = extras.getString(EXTRA_TV)

            if (idMovie != null) {
                viewModel.setSelectedMovie(idMovie)
                populateMovie(viewModel.getMovie())
            }

            if (idTvShow != null) {
                viewModel.setSelectedTvShow(idTvShow)
                populateTvShow(viewModel.getTvShows())
            }
        }
    }

    private fun populateMovie(movies: MoviesModel) {
        with(binding) {
            tvTitle.text = movies.title
            tvGenre.text = movies.genre
            tvLength.text = movies.length
            tvRelease.text = movies.release.toString()
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
            tvRelease.text = tvShows.release.toString()
            tvDetail.text = tvShows.description
            Glide.with(binding.root)
                    .load(tvShows.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh))
                    .error(R.drawable.ic_broken_image)
                    .into(imageViewDetail)
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