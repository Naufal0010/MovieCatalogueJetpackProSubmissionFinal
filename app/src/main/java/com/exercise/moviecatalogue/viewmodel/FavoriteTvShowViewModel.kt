package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

class FavoriteTvShowViewModel(private val mMovieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowsModel>> =
        mMovieCatalogueRepository.getFavoriteTvShows()

    fun setFavoriteTvShow(tvShow: TvShowsModel) {
        val newState = !tvShow.favorited
        mMovieCatalogueRepository.setTvShowFavorite(tvShow, newState)
    }
}