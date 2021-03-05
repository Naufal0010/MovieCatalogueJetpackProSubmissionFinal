package com.exercise.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]

    private val movieId = dummyMovie.moviesId
    private val tvShowId = dummyTvShow.tvShowsId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<MoviesModel>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowsModel>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MoviesModel>()
        movie.value = dummyMovie

        `when`(movieCatalogueRepository.getMoviesWithId(movieId)).thenReturn(movie)
        val movieModel = viewModel.getMovie().value as MoviesModel
        verify(movieCatalogueRepository).getMoviesWithId(movieId)
        assertNotNull(movieModel)
        assertEquals(dummyMovie.moviesId, movieModel.moviesId)
        assertEquals(dummyMovie.title, movieModel.title)
        assertEquals(dummyMovie.description, movieModel.description)
        assertEquals(dummyMovie.poster, movieModel.poster)
        assertEquals(dummyMovie.genre, movieModel.genre)
        assertEquals(dummyMovie.length, movieModel.length)
        assertEquals(dummyMovie.release, movieModel.release)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShows() {
        val tvShow = MutableLiveData<TvShowsModel>()
        tvShow.value = dummyTvShow

        `when`(movieCatalogueRepository.getTvShowsWithId(tvShowId)).thenReturn(tvShow)
        val tvShowModel = viewModel.getTvShows().value as TvShowsModel
        verify(movieCatalogueRepository).getTvShowsWithId(tvShowId)
        assertNotNull(tvShowModel)
        assertEquals(dummyTvShow.tvShowsId, tvShowModel.tvShowsId)
        assertEquals(dummyTvShow.title, tvShowModel.title)
        assertEquals(dummyTvShow.description, tvShowModel.description)
        assertEquals(dummyTvShow.poster, tvShowModel.poster)
        assertEquals(dummyTvShow.genre, tvShowModel.genre)
        assertEquals(dummyTvShow.length, tvShowModel.length)
        assertEquals(dummyTvShow.release, tvShowModel.release)

        viewModel.getTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}