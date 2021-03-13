package com.exercise.moviecatalogue.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exercise.moviecatalogue.data.source.remote.response.ApiResponse
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse
import com.exercise.moviecatalogue.utils.EspressoIdlingResources
import com.exercise.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MoviesResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MoviesResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowsResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowsResponse>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultTvShow
    }
}