package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.exercise.moviecatalogue.model.MoviesModel
import com.exercise.moviecatalogue.model.TvShowsModel
import com.exercise.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var idMovie : String
    private lateinit var idTvShow : String

    fun setSelectedMovie(idMovie: String) {
        this.idMovie = idMovie
    }

    fun setSelectedTvShow(idTvShow: String) {
        this.idTvShow = idTvShow
    }

    fun getMovie(): MoviesModel {

        lateinit var movies: MoviesModel

        val moviesModel = DataDummy.generateMovies()
        for (movie in moviesModel) {
            if (movie.moviesId == idMovie) {
                movies = movie
            }
        }

        return movies
    }

    fun getTvShows(): TvShowsModel {

        lateinit var tvShows: TvShowsModel

        val tvShow = DataDummy.generateTvShows()
        for (tv in tvShow) {
            if (tv.tvShowsId == idTvShow) {
                tvShows = tv
            }
        }

        return tvShows
    }
}