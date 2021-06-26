package com.rizki.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface AppDao {

    @Query("SELECT * FROM moviesentities")
    fun getMoviesDao(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM moviesentities WHERE favourite = 1")
    fun getFavouriteMovie(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tvshowsentities")
    fun getTvShowsDao(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM tvshowsentities WHERE favourite = 1")
    fun getFavouriteTvShow(): LiveData<List<TvShowEntity>>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE moviesId = :movieId")
    fun getMovieById(movieId: String): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM tvshowsentities WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}