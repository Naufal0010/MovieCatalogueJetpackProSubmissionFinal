package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel

class FavoriteMovieViewModel(private val mMovieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MoviesModel>> =
        mMovieCatalogueRepository.getFavoriteMovies()

    fun setFavoriteMovie(movie: MoviesModel) {
        val newState = !movie.favorited
        mMovieCatalogueRepository.setMovieFavorite(movie, newState)
    }
}