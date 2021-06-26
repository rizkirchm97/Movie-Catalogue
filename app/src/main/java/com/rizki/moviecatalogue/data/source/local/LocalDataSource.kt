package com.rizki.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.data.source.local.room.AppDao

class LocalDataSource private constructor(private val mAppDao: AppDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(appDao: AppDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(appDao)
    }

    fun getAllLocalMovies(): LiveData<List<MovieEntity>> = mAppDao.getMoviesDao()
    fun getFavouriteMovie(): LiveData<List<MovieEntity>> = mAppDao.getFavouriteMovie()
    fun getMovieById(movieId: String): LiveData<MovieEntity> =
        mAppDao.getMovieById(movieId)
    fun insertMovie(movie: List<MovieEntity>) = mAppDao.insertMovie(movie)
    fun updateMovie(movie: MovieEntity) = mAppDao.updateMovie(movie)
    fun setMovieFavourite(movie: MovieEntity, newState: Boolean) {
        movie.favourite = newState
        mAppDao.updateMovie(movie)
    }

    fun getAllLocalTvShows(): LiveData<List<TvShowEntity>> = mAppDao.getTvShowsDao()
    fun getFavouriteTvShow(): LiveData<List<TvShowEntity>> = mAppDao.getFavouriteTvShow()
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity> =
        mAppDao.getTvShowById(tvShowId)
    fun insertTvShow(tvShow: List<TvShowEntity>) = mAppDao.insertTvShow(tvShow)
    fun updateTvShow(tvSHow: TvShowEntity) = mAppDao.updateTvShow(tvSHow)
    fun setTvShowFavourite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favourite = newState
        mAppDao.updateTvShow(tvShow)
    }
}