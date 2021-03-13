package com.exercise.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.exercise.moviecatalogue.data.source.local.LocalDataSource
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.data.source.remote.response.ApiResponse
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse
import com.exercise.moviecatalogue.utils.AppExecutors
import com.exercise.moviecatalogue.vo.Resource

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors) :
    MovieCatalogueDataSource {

    companion object {

        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MoviesModel>>> {
        return object : NetworkBoundResource<List<MoviesModel>, List<MoviesResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<List<MoviesModel>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MoviesModel>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(movieResponses: List<MoviesResponse>) {
                val movieList = ArrayList<MoviesModel>()

                for (response in movieResponses) {
                    val movie = MoviesModel(response.moviesId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false)
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
                    val movie = MoviesModel(response.moviesId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false)
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }


    override fun getAllTvShows(): LiveData<Resource<List<TvShowsModel>>> {
        return object : NetworkBoundResource<List<TvShowsModel>, List<TvShowsResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<List<TvShowsModel>> =
                localDataSource.getAllTvShows()

            override fun shouldFetch(data: List<TvShowsModel>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowsResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(tvShowResponses: List<TvShowsResponse>) {
                val tvShowList = ArrayList<TvShowsModel>()

                for (response in tvShowResponses) {
                    val tvShow = TvShowsModel(response.tvShowsId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false)
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
                    val tvShow = TvShowsModel(response.tvShowsId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release,
                        false)
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MoviesModel, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setTvShowFavorite(tvShow: TvShowsModel, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
}