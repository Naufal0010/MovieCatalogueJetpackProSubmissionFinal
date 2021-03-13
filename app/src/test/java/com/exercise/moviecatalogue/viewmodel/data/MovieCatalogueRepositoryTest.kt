package com.exercise.moviecatalogue.viewmodel.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.exercise.moviecatalogue.data.source.local.LocalDataSource
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.utils.AppExecutors
import com.exercise.moviecatalogue.utils.DataDummy
import com.exercise.moviecatalogue.viewmodel.utils.PagedListUtils
import com.exercise.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateMovies()
    private val tvShowResponses = DataDummy.generateTvShows()

    @Test
    fun getAllMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesModel>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllMovies()

        val movieEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsModel>
        `when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllTvShows()

        val tvShowEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getAllMovieFavorite() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesModel>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteMovies()

        val movieFavoriteEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieFavoriteEntities)
        assertEquals(movieResponses.size.toLong(), movieFavoriteEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShowFavorite() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowsModel>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteTvShows()

        val tvShowFavoriteEntities =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoriteTvShows()
        assertNotNull(tvShowFavoriteEntities)
        assertEquals(tvShowResponses.size.toLong(), tvShowFavoriteEntities.data?.size?.toLong())
    }
}