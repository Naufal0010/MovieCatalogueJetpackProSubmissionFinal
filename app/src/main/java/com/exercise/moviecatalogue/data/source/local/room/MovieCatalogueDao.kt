package com.exercise.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.exercise.moviecatalogue.data.source.local.entity.MoviesModel
import com.exercise.moviecatalogue.data.source.local.entity.TvShowsModel

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MoviesModel>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): DataSource.Factory<Int, TvShowsModel>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE moviesId = :moviesId")
    fun getMovieById(moviesId: String): LiveData<MoviesModel>

    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowsId")
    fun getTvShowById(tvShowsId: String): LiveData<TvShowsModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MoviesModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowsModel>)

    @Update
    fun updateMovie(movie: MoviesModel)

    @Update
    fun updateTvShow(tvShow: TvShowsModel)

    @Query("SELECT * FROM movieentities WHERE favorited = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MoviesModel>

    @Query("SELECT * FROM tvshowentities WHERE favorited = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowsModel>
}