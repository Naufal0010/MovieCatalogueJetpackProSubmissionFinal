package com.exercise.moviecatalogue.di

import android.content.Context
import com.exercise.moviecatalogue.data.MovieCatalogueRepository
import com.exercise.moviecatalogue.data.source.remote.RemoteDataSource
import com.exercise.moviecatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}