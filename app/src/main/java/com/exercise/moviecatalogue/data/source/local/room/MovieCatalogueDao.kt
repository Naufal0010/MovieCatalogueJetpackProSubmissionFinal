package com.exercise.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MoviesModel>>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): LiveData<List<TvShowsModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MoviesModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowsModel>)

    @Update
    fun updateMovie(movie: MoviesModel)

    @Update
    fun updateTvShow(tvShow: TvShowsModel)

    @Query("SELECT * FROM movieentities WHERE moviesId = :moviesId")
    fun getMovieById(moviesId: String): LiveData<MoviesModel>

    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowsId")
    fun getTvShowById(tvShowsId: String): LiveData<TvShowsModel>
}