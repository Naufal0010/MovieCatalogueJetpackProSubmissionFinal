package com.exercise.moviecatalogue.model

data class MoviesModel(
    var moviesId: String,
    var title: String,
    var description: String,
    var poster: String,
    var genre: String,
    var length: String,
    var release: Int
)
