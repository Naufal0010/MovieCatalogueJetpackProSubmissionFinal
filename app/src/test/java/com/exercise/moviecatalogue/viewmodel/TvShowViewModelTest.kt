package com.exercise.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowsModel>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowsModel>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = Resource.success(pagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowsModel>>>()
        tvShows.value = dummyTvShows

        `when`(movieCatalogueRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowModel = viewModel.getTvShows().value?.data
        verify(movieCatalogueRepository).getAllTvShows()
        assertNotNull(tvShowModel)
        assertEquals(10, tvShowModel?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}