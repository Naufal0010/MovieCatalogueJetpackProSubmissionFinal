package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.vo.Resource

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private val idMovie = MutableLiveData<String>()
    private val idTvShow = MutableLiveData<String>()

    fun setSelectedMovie(idMovie: String) {
        this.idMovie.value = idMovie
    }

    fun setSelectedTvShow(idTvShow: String) {
        this.idTvShow.value = idTvShow
    }

    var movie: LiveData<Resource<MoviesModel>> = Transformations.switchMap(idMovie) { mMovieId ->
        movieCatalogueRepository.getMoviesWithId(mMovieId)
    }

    var tvShow: LiveData<Resource<TvShowsModel>> =
        Transformations.switchMap(idTvShow) { mTvShowId ->
            movieCatalogueRepository.getTvShowsWithId(mTvShowId)
        }

    fun setFavorite() {

        val resourceMovie = movie.value
        val resourceTvShow = tvShow.value

        if (resourceMovie != null) {
            val movieWithData = resourceMovie.data

            if (movieWithData != null) {
                val newState = !movieWithData.favorited
                movieCatalogueRepository.setMovieFavorite(movieWithData, newState)
            }
        }

        if (resourceTvShow != null) {
            val tvShowWithData = resourceTvShow.data

            if (tvShowWithData != null) {
                val newState = !tvShowWithData.favorited
                movieCatalogueRepository.setTvShowFavorite(tvShowWithData, newState)
            }
        }
    }
}