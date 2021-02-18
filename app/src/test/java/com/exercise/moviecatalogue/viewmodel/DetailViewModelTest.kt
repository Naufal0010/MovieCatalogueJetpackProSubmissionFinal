package com.exercise.moviecatalogue.viewmodel

import com.exercise.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateMovies()[0]
    private val dummyTvShow = DataDummy.generateTvShows()[0]

    private val movieId = dummyMovie.moviesId
    private val tvShowId = dummyTvShow.tvShowsId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.moviesId)
        val movieModel = viewModel.getMovie()
        assertNotNull(movieModel)
        assertEquals(dummyMovie.moviesId, movieModel.moviesId)
        assertEquals(dummyMovie.title, movieModel.title)
        assertEquals(dummyMovie.description, movieModel.description)
        assertEquals(dummyMovie.poster, movieModel.poster)
        assertEquals(dummyMovie.genre, movieModel.genre)
        assertEquals(dummyMovie.length, movieModel.length)
        assertEquals(dummyMovie.release, movieModel.release)
    }

    @Test
    fun getTvShows() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowsId)
        val tvShowModel = viewModel.getTvShows()
        assertNotNull(tvShowModel)
        assertEquals(dummyTvShow.tvShowsId, tvShowModel.tvShowsId)
        assertEquals(dummyTvShow.title, tvShowModel.title)
        assertEquals(dummyTvShow.description, tvShowModel.description)
        assertEquals(dummyTvShow.poster, tvShowModel.poster)
        assertEquals(dummyTvShow.genre, tvShowModel.genre)
        assertEquals(dummyTvShow.length, tvShowModel.length)
        assertEquals(dummyTvShow.release, tvShowModel.release)
    }
}