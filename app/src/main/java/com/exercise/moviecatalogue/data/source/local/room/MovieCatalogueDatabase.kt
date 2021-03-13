package com.exercise.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

@Database(entities = [MoviesModel::class, TvShowsModel::class],
    version = 1,
    exportSchema = false)
abstract class MovieCatalogueDatabase : RoomDatabase() {

    abstract fun movieCatalogueDao(): MovieCatalogueDao

    companion object {

        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                    MovieCatalogueDatabase::class.java,
                    "MovieCatalogue.db").build()
            }
    }
}