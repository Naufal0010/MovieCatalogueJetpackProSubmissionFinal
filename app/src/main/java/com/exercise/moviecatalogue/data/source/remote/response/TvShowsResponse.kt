package com.exercise.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowsResponse(
        var tvShowsId: String,
        var title: String,
        var description: String,
        var genre: String,
        var poster: String,
        var length: String,
        var release: String
) : Parcelable
