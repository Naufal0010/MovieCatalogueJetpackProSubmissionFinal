package com.exercise.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import com.exercise.moviecatalogue.model.MoviesModel
import com.exercise.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies() : List<MoviesModel> = DataDummy.generateMovies()
}