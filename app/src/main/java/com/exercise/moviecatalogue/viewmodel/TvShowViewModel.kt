package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.exercise.moviecatalogue.model.TvShowsModel
import com.exercise.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShows() : List<TvShowsModel> = DataDummy.generateTvShows()
}