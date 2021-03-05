package com.exercise.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<List<MoviesModel>>

    fun getMoviesWithId(movieId: String): LiveData<MoviesModel>

    fun getAllTvShows(): LiveData<List<TvShowsModel>>

    fun getTvShowsWithId(tvShowId: String): LiveData<TvShowsModel>
}