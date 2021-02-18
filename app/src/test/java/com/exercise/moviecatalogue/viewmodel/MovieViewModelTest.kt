package com.exercise.moviecatalogue.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieModel = viewModel.getMovies()
        assertNotNull(movieModel)
        assertEquals(10, movieModel.size)
    }
}