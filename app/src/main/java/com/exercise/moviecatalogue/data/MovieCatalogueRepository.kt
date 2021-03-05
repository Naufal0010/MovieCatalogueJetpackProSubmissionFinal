package com.exercise.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource {

    companion object {

        @Volatile
        private var instance: MovieCatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getAllMovies(): LiveData<List<MoviesModel>> {
        val movieResult = MutableLiveData<List<MoviesModel>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MoviesResponse>) {
                val movieList = ArrayList<MoviesModel>()
                for (response in movieResponse) {
                    val movie = MoviesModel(
                        response.moviesId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release
                    )

                    movieList.add(movie)
                }

                movieResult.postValue(movieList)
            }
        })

        return movieResult
    }

    override fun getMoviesWithId(movieId: String): LiveData<MoviesModel> {
        val movieResult = MutableLiveData<MoviesModel>()

        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MoviesResponse>) {
                lateinit var movie: MoviesModel
                for (response in movieResponse) {
                    if (response.moviesId == movieId) {
                        movie = MoviesModel(
                            response.moviesId,
                            response.title,
                            response.description,
                            response.genre,
                            response.poster,
                            response.length,
                            response.release
                        )
                    }
                }

                movieResult.postValue(movie)
            }
        })

        return movieResult
    }


    override fun getAllTvShows(): LiveData<List<TvShowsModel>> {
        val tvShowsResult = MutableLiveData<List<TvShowsModel>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowsResponse>) {
                val tvShowList = ArrayList<TvShowsModel>()
                for (response in tvShowResponse) {
                    val tvShow = TvShowsModel(
                        response.tvShowsId,
                        response.title,
                        response.description,
                        response.genre,
                        response.poster,
                        response.length,
                        response.release
                    )

                    tvShowList.add(tvShow)
                }

                tvShowsResult.postValue(tvShowList)
            }
        })

        return tvShowsResult
    }

    override fun getTvShowsWithId(tvShowId: String): LiveData<TvShowsModel> {
        val tvShowResult = MutableLiveData<TvShowsModel>()

        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(tvShowResponse: List<TvShowsResponse>) {
                lateinit var tvShow: TvShowsModel
                for (response in tvShowResponse) {
                    if (response.tvShowsId == tvShowId) {
                        tvShow = TvShowsModel(
                            response.tvShowsId,
                            response.title,
                            response.description,
                            response.genre,
                            response.poster,
                            response.length,
                            response.release
                        )
                    }
                }

                tvShowResult.postValue(tvShow)
            }
        })

        return tvShowResult
    }
}