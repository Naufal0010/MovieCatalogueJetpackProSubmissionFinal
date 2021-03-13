package com.exercise.moviecatalogue.viewmodel.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.exercise.moviecatalogue.data.MovieCatalogueDataSource
import com.exercise.moviecatalogue.data.NetworkBoundResource
import com.exercise.moviecatalogue.data.source.local.LocalDataSource
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.data.source.remote.response.ApiResponse
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse
import com.exercise.moviecatalogue.utils.AppExecutors
import com.exercise.moviecatalogue.vo.Resource

class FakeMovieCatalogueRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieCatalogueDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MoviesModel>>> {
        return object :
            NetworkBoundResource<PagedList<MoviesModel>, List<MoviesResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<MoviesModel>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesModel>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MoviesResponse>) {
                val movieList = ArrayList<MoviesModel>()

                for (response in data) {
                    val movie = MoviesModel(
                        response.moviesId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getMoviesWithId(movieId: String): LiveData<Resource<MoviesModel>> {
        return object : NetworkBoundResource<MoviesModel, List<MoviesResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<MoviesModel> =
                localDataSource.getMovieWithId(movieId)

            override fun shouldFetch(data: MoviesModel?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MoviesResponse>) {
                val movieList = ArrayList<MoviesModel>()

                for (response in data) {
                    val movie = MoviesModel(
                        response.moviesId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }


    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowsModel>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowsModel>, List<TvShowsResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<TvShowsModel>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowsModel>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowsResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowsResponse>) {
                val tvShowList = ArrayList<TvShowsModel>()

                for (response in data) {
                    val tvShow = TvShowsModel(
                        response.tvShowsId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false
                    )
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getTvShowsWithId(tvShowId: String): LiveData<Resource<TvShowsModel>> {
        return object : NetworkBoundResource<TvShowsModel, List<TvShowsResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<TvShowsModel> =
                localDataSource.getTvShowWithId(tvShowId)

            override fun shouldFetch(data: TvShowsModel?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvShowsResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowsResponse>) {
                val tvShowList = ArrayList<TvShowsModel>()

                for (response in data) {
                    val tvShow = TvShowsModel(
                        response.tvShowsId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false
                    )
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MoviesModel>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowsModel>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setMovieFavorite(movie: MoviesModel, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setTvShowFavorite(tvShow: TvShowsModel, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
}