package com.rizki.moviecatalogue.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.vo.Resource

class DetailMoviesViewModel(private val appRepository: AppRepository): ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovies(moviesId: String) {
        this.movieId.value = moviesId
    }

    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        appRepository.getMovieById(mMovieId)
    }

    fun setFav() {
        val movieResource = movie.value
        if (movieResource != null) {
            val movieId = movieResource.data

            if (movieId != null) {
                val movieEntity = movieId

                val newState = !movieEntity.favourite
                appRepository.setMovieFavourite(movieEntity, newState)
            }
        }
    }

}