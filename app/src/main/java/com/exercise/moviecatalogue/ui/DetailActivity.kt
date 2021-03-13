package com.exercise.moviecatalogue.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.databinding.ActivityDetailBinding
import com.exercise.moviecatalogue.viewmodel.DetailViewModel
import com.exercise.moviecatalogue.viewmodel.ViewModelFactory
import com.exercise.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val idMovie = extras.getString(EXTRA_MOVIE)
            val idTvShow = extras.getString(EXTRA_TV)

            if (idMovie != null) {
                viewModel.setSelectedMovie(idMovie)
                viewModel.movie.observe(this, { movies ->
                    when (movies.status) {
                        Status.LOADING -> setProgressBar(true)
                        Status.SUCCESS -> if (movies.data != null) {
                            setProgressBar(false)
                            populateMovie(movies.data)
                        }
                        Status.ERROR -> {
                            setProgressBar(false)
                            Toast.makeText(
                                applicationContext,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }

            if (idTvShow != null) {
                viewModel.setSelectedTvShow(idTvShow)
                viewModel.tvShow.observe(this, { tvShows ->
                    when (tvShows.status) {
                        Status.LOADING -> setProgressBar(true)
                        Status.SUCCESS -> if (tvShows.data != null) {
                            setProgressBar(false)
                            populateTvShow(tvShows.data)
                        }
                        Status.ERROR -> {
                            setProgressBar(false)
                            Toast.makeText(
                                applicationContext,
                                resources.getString(R.string.error),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }
        }
    }

    private fun populateMovie(movies: MoviesModel) {
        var status = movies.favorited
        setFavorite(status)

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

            fabFavorite.setOnClickListener {
                status = !status
                setFavorite(status)
                viewModel.setFavorite()
            }
        }
    }

    private fun populateTvShow(tvShows: TvShowsModel) {
        var status = tvShows.favorited
        setFavorite(status)

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

            fabFavorite.setOnClickListener {
                status = !status
                setFavorite(status)
                viewModel.setFavorite()
            }
        }
    }

    private fun setProgressBar(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border
                )
            )
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