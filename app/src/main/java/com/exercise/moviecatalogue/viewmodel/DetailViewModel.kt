package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    private lateinit var idMovie : String
    private lateinit var idTvShow : String

    fun setSelectedMovie(idMovie: String) {
        this.idMovie = idMovie
    }

    fun setSelectedTvShow(idTvShow: String) {
        this.idTvShow = idTvShow
    }

    fun getMovie(): LiveData<MoviesModel> = movieCatalogueRepository.getMoviesWithId(idMovie)

    fun getTvShows(): LiveData<TvShowsModel> = movieCatalogueRepository.getTvShowsWithId(idTvShow)
}