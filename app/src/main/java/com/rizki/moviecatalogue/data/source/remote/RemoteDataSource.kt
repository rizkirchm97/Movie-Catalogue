package com.rizki.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizki.moviecatalogue.data.source.remote.response.MovieResponse
import com.rizki.moviecatalogue.data.source.remote.response.TvShowResponse
import com.rizki.moviecatalogue.utils.EspressoIdlingResources
import com.rizki.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
                            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS)

        return resultMovie
    }

    fun getMovieById(movieId: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResources.increment()
        val resultDetail = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultDetail.value = ApiResponse.success(jsonHelper.loadMovieById(movieId))
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultDetail
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvsShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvsShow.value = ApiResponse.success(jsonHelper.loadTvShow())
                            EspressoIdlingResources.decrement()
                            }, SERVICE_LATENCY_IN_MILLIS )
        return resultTvsShow
    }

    fun getTvShowById(tvShowId: String): LiveData<ApiResponse<TvShowResponse>> {
        EspressoIdlingResources.increment()
        val resultDetail = MutableLiveData<ApiResponse<TvShowResponse>>()
        handler.postDelayed({
            resultDetail.value = ApiResponse.success(jsonHelper.loadTvShowById(tvShowId))
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultDetail
    }

    interface LoadTvShowCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<TvShowResponse>)
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

}