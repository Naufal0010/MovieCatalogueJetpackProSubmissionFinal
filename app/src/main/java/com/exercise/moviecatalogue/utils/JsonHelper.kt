package com.exercise.moviecatalogue.utils

import android.content.Context
import com.exercise.moviecatalogue.data.source.remote.response.MoviesResponse
import com.exercise.moviecatalogue.data.source.remote.response.TvShowsResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesResponse> {
        val list = ArrayList<MoviesResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("Movies.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0..listArray.length()) {
                val movie = listArray.getJSONObject(i)

                with(movie) {
                    val id = getString("id")
                    val title = getString("title")
                    val overview = getString("overview")
                    val genre = getString("genre")
                    val posterPath = getString("poster_path")
                    val length = getString("length")
                    val release = getString("release")

                    val movieResponse = MoviesResponse(id, title, overview, genre, posterPath, length, release,false)
                    list.add(movieResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShows(): List<TvShowsResponse> {
        val list = ArrayList<TvShowsResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("TvShows.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0..listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                with(tvShow) {
                    val id = getString("id")
                    val title = getString("title")
                    val overview = getString("overview")
                    val genre = getString("genre")
                    val posterPath = getString("poster_path")
                    val length = getString("length")
                    val release = getString("release")

                    val tvShowResponse = TvShowsResponse(id, title, overview, genre, posterPath, length, release, false)
                    list.add(tvShowResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}