package com.rizki.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.vo.Resource

interface AppDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>
    fun getMovieById(movieId: String): LiveData<Resource<MovieEntity>>
    fun getAllTvShows(): LiveData<Resource<List<TvShowEntity>>>
    fun getTvShowById(tvShowId: String): LiveData<Resource<TvShowEntity>>
    fun getMovieFavourite(): LiveData<List<MovieEntity>>
    fun getTvShowFavourite(): LiveData<List<TvShowEntity>>
    fun setMovieFavourite(movie: MovieEntity, state: Boolean)
    fun setTvShowFavourite(tvSHow: TvShowEntity, state: Boolean)
}