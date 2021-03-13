package com.exercise.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.local.room.MovieCatalogueDao

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    fun getAllMovies(): DataSource.Factory<Int, MoviesModel> = mMovieCatalogueDao.getMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowsModel> = mMovieCatalogueDao.getTvShows()

    fun getMovieWithId(movieId: String): LiveData<MoviesModel> =
        mMovieCatalogueDao.getMovieById(movieId)

    fun getTvShowWithId(tvShowId: String): LiveData<TvShowsModel> =
        mMovieCatalogueDao.getTvShowById(tvShowId)

    fun insertMovies(movies: List<MoviesModel>) = mMovieCatalogueDao.insertMovie(movies)

    fun insertTvShows(tvShows: List<TvShowsModel>) = mMovieCatalogueDao.insertTvShow(tvShows)

    fun getFavoriteMovies(): DataSource.Factory<Int, MoviesModel> =
        mMovieCatalogueDao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowsModel> =
        mMovieCatalogueDao.getFavoriteTvShows()

    fun setMovieFavorite(movie: MoviesModel, newState: Boolean) {
        movie.favorited = newState
        mMovieCatalogueDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowsModel, newState: Boolean) {
        tvShow.favorited = newState
        mMovieCatalogueDao.updateTvShow(tvShow)
    }


    companion object {

        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }
}