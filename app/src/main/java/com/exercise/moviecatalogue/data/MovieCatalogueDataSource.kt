package com.exercise.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MoviesModel>>>

    fun getMoviesWithId(movieId: String): LiveData<Resource<MoviesModel>>

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowsModel>>>

    fun getTvShowsWithId(tvShowId: String): LiveData<Resource<TvShowsModel>>

    fun setMovieFavorite(movie: MoviesModel, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowsModel, state: Boolean)

    fun getFavoriteMovies(): LiveData<PagedList<MoviesModel>>

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowsModel>>
}