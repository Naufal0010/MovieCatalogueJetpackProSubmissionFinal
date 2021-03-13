package com.exercise.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvShowsModel(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowId")
        var tvShowsId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "poster")
        var poster: String,

        @ColumnInfo(name = "length")
        var length: String,

        @ColumnInfo(name = "release")
        var release: String,

        @ColumnInfo(name = "favorited")
        var favorited: Boolean = false
)
