package com.exercise.moviecatalogue.viewmodel

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShowModel = viewModel.getTvShows()
        assertNotNull(tvShowModel)
        assertEquals(10, tvShowModel.size)
    }
}