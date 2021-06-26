package com.rizki.moviecatalogue.utils

import android.content.Context
import android.util.Log
import com.rizki.moviecatalogue.data.source.remote.response.MovieResponse
import com.rizki.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return  try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponse.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val quote = movie.getString("quote")
                val genre = movie.getString("genre")
                val totalTime = movie.getString("totalTime")
                val overview = movie.getString("overview")
                val releaseDate = movie.getString("releaseDate")
                val imagePath = movie.getString("imagePath")

                val movieResponse = MovieResponse(id, title, quote, genre, totalTime, overview, releaseDate, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadMovieById(movieId: String): MovieResponse {
        val fileName = String.format("MoviesResponse.json", movieId)
        var movieResponse: MovieResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("movies")
                for (i in 0 until listArray.length()) {
                    val movie = listArray.getJSONObject(i)

                    val id = movie.getString("id")
                    val title = movie.getString("title")
                    val quote = movie.getString("quote")
                    val genre = movie.getString("genre")
                    val totalTime = movie.getString("totalTime")
                    val overview = movie.getString("overview")
                    val releaseDate = movie.getString("releaseDate")
                    val imagePath = movie.getString("imagePath")

                    movieResponse = MovieResponse(id, title, quote, genre, totalTime, overview, releaseDate, imagePath)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieResponse as MovieResponse
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("tvId")
                val title = tvShow.getString("title")
                val quote = tvShow.getString("quote")
                val genre = tvShow.getString("genre")
                val totalTime = tvShow.getString("totalTime")
                val overview = tvShow.getString("overview")
                val network = tvShow.getString("network")
                val imagePath = tvShow.getString("imagePath")

                val tvShowResponse = TvShowResponse(
                    id, title, quote, genre, totalTime,
                    overview, network, imagePath)
                Log.d("Data tvShowResponse", tvShowResponse.toString())
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShowById(tvShowId: String): TvShowResponse {
        val fileName = String.format("TvShowResponse.json", tvShowId)
        var tvShowResponse: TvShowResponse? = null
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("tvShows")
                for (i in 0 until listArray.length()) {
                    val movie = listArray.getJSONObject(i)

                    val id = movie.getString("tvId")
                    val title = movie.getString("title")
                    val quote = movie.getString("quote")
                    val genre = movie.getString("genre")
                    val totalTime = movie.getString("totalTime")
                    val overview = movie.getString("overview")
                    val releaseDate = movie.getString("network")
                    val imagePath = movie.getString("imagePath")

                    tvShowResponse = TvShowResponse(id, title, quote, genre, totalTime, overview, releaseDate, imagePath)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvShowResponse as TvShowResponse
    }
}