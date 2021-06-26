package com.rizki.moviecatalogue.ui.favourite.favouritemovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rizki.moviecatalogue.data.source.AppRepository
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity

class MovieFavouriteViewModel(private val appRepository: AppRepository): ViewModel() {

    fun getFavMovie(): LiveData<List<MovieEntity>> = appRepository.getMovieFavourite()
}