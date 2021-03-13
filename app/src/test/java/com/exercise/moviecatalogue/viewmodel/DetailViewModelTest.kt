package com.exercise.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.utils.DataDummy
import com.exercise.moviecatalogue.vo.Resource
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
    private lateinit var movieObserver: Observer<Resource<MoviesModel>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowsModel>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        val dummyMovieDetail = Resource.success(DataDummy.generateDummyMovies()[0])
        val movie = MutableLiveData<Resource<MoviesModel>>()
        movie.value = dummyMovieDetail

        `when`(movieCatalogueRepository.getMoviesWithId(movieId)).thenReturn(movie)
        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovieDetail)
    }

    @Test
    fun getTvShows() {
        val dummyTvShowDetail = Resource.success(DataDummy.generateDummyTvShows()[0])
        val tvShow = MutableLiveData<Resource<TvShowsModel>>()
        tvShow.value = dummyTvShowDetail

        `when`(movieCatalogueRepository.getTvShowsWithId(tvShowId)).thenReturn(tvShow)
        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShowDetail)
    }
}