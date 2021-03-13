package com.exercise.moviecatalogue.di

import android.content.Context
import com.exercise.moviecatalogue.data.MovieCatalogueDataSource
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.local.LocalDataSource
import com.exercise.moviecatalogue.data.source.local.room.MovieCatalogueDatabase
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.utils.AppExecutors
import com.exercise.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieCatalogueDao())
        val appExecutors = AppExecutors()

        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}