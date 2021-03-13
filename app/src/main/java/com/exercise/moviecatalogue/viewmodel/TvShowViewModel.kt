package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.vo.Resource

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowsModel>>> =
        movieCatalogueRepository.getAllTvShows()
}